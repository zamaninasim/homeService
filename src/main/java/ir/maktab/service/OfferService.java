package ir.maktab.service;

import ir.maktab.data.dao.OfferRepository;
import ir.maktab.data.dao.OrderRepository;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.exception.EntityNotExistException;
import ir.maktab.exception.NotMatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public Order addOfferToOrder(Offer offer) {
        Set<SubService> expertServices = offer.getExpert().getServices();
        SubService subService = offer.getOrder().getSubService();
        if (expertServices.contains(subService) && subService.getBasePrice() <= offer.getProposedPrice()) {
            Offer savedOffer = save(offer);
            System.out.println(savedOffer);
            Order order = savedOffer.getOrder();
            order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SELECTION);
            order.getOffers().add(offer);
            orderRepository.save(order);
            return order;
        } else {
            throw new NotMatchException("your offer is not match for this Order!");
        }
    }

    public List<Offer> findByOrder(Order order) {
        return offerRepository.findByOrder(order, Sort.by("expert.score", "proposedPrice").descending());
    }

    public Offer findByOrderAndExpert(Order order, Expert expert) {
        Optional<Offer> offer = offerRepository.findByOrderAndExpert(order, expert);
        return offer.orElseThrow(() -> new EntityNotExistException("offer not found!"));
    }
}
