package ir.maktab.service;

import ir.maktab.data.dao.OfferRepository;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.enumeration.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferRepository offerRepository;

    public void save(Offer offer) {
        offerRepository.save(offer);
    }

    public void addOfferToInstruction(Offer offer) {
        Set<SubService> expertServices = offer.getExpert().getServices();
        SubService subService = offer.getOrder().getSubService();
        if (expertServices.contains(subService)) {
            save(offer);
            offer.getOrder().setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SELECTION);
        } else {
            throw new RuntimeException("this Instruction service is not in your field.");
        }
    }
}
