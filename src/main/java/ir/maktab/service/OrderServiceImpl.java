package ir.maktab.service;

import ir.maktab.data.dao.OrderRepository;
import ir.maktab.data.model.entity.Order;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public void save(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        orderRepository.save(order);
    }

    public OrderDto findById(Integer id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order order = optionalOrder.orElseThrow(() -> new EntityNotExistException("this order not exist!"));
        return modelMapper.map(order,OrderDto.class);
    }
//TODO
/*    public Offer findAcceptedOfferOfOrder(Order order) {
        Offer acceptedOffer = null;
        if (order.getOrderStatus().equals(OrderStatus.PAID)) {
            Set<Offer> offers = order.getOffers();
            for (Offer offer : offers) {
                if (offer.getOfferStatus().equals(OfferStatus.ACCEPTED)) {
                    acceptedOffer = offer;
                }
            }
            return acceptedOffer;
        } else {
            throw new RuntimeException("Order not Paid!");
        }
    }*/
}
