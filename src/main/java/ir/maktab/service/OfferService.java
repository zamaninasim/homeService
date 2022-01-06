package ir.maktab.service;

import ir.maktab.dao.OfferDao;
import ir.maktab.model.entity.Offer;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.enumeration.InstructionStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferDao offerDao;

    public void save(Offer offer) {
        offerDao.save(offer);
    }

    public void addOfferToInstruction(Offer offer) {
        Set<SubService> expertServices = offer.getExpert().getServices();
        SubService subService = offer.getInstruction().getSubService();
        if (expertServices.contains(subService)) {
            save(offer);
            offer.getInstruction().setOrderStatus(InstructionStatus.WAITING_FOR_EXPERT_SELECTION);
        } else {
            throw new RuntimeException("this Instruction service is not in your field.");
        }
    }
}
