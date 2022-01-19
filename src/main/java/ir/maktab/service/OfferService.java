package ir.maktab.service;

import ir.maktab.data.dao.OfferRepository;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.exception.EntityNotExistException;
import ir.maktab.exception.NotMatchException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public void save(OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        offerRepository.save(offer);
    }

    public OrderDto addOfferToOrder(OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        Set<SubService> expertServices = offer.getExpert().getServices();
        SubService subService = offer.getOrder().getSubService();
        if (expertServices.contains(subService) && subService.getBasePrice() <= offer.getProposedPrice()) {
            save(offerDto);
            Order order = offer.getOrder();
            order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SELECTION);
            order.getOffers().add(offer);
            OrderDto orderDto = modelMapper.map(order, OrderDto.class);
            orderService.save(orderDto);
            return orderDto;
        } else {
            throw new NotMatchException("your offer is not match for this Order!");
        }
    }

    public List<OfferDto> findByOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        List<Offer> offers = offerRepository.findByOrder(order, Sort.by("expert.score", "proposedPrice").descending());
        return offers.stream().map(offer->modelMapper.map(offer,OfferDto.class)).collect(Collectors.toList());
    }

    public OfferDto findByOrderAndExpert(OrderDto orderDto, ExpertDto expertDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        Expert expert = modelMapper.map(expertDto, Expert.class);
        Optional<Offer> optionalOffer = offerRepository.findByOrderAndExpert(order, expert);
        Offer offer = optionalOffer.orElseThrow(() -> new EntityNotExistException("offer not found!"));
        return modelMapper.map(offer,OfferDto.class);
    }
}
