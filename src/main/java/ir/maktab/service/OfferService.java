package ir.maktab.service;

import ir.maktab.data.dao.OfferRepository;
import ir.maktab.data.dao.OrderRepository;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.exception.NotMatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;
    private final OrderRepository orderRepository;

    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public void addOfferToOrder(Offer offer) {
        Set<SubService> expertServices = offer.getExpert().getServices();
        SubService subService = offer.getOrder().getSubService();
        if (expertServices.contains(subService)) {
            save(offer);
            Order order = offer.getOrder();
            order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SELECTION);
            orderRepository.save(order);
        } else {
            throw new NotMatchException("this Instruction service is not in your field.");
        }
    }
}
