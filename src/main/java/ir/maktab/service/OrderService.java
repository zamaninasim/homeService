package ir.maktab.service;

import ir.maktab.data.dao.OrderRepository;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.enumeration.OfferStatus;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void save(Order order) {
        Optional<Order> orderByTrackingNumber = orderRepository.findById(order.getId());
        if (orderByTrackingNumber.isPresent()) {
            throw new EntityIsExistException("this order is exist!");
        } else {
            orderRepository.save(order);
        }
    }

    public Order findById(Integer id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElseThrow(() -> new EntityNotExistException("this order not exist!"));
    }

    public Offer findAcceptedOfferOfInstruction(Order order) {
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
            throw new RuntimeException("Instruction not Paid!");
        }
    }
}
