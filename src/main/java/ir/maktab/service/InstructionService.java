package ir.maktab.service;

import ir.maktab.dao.InstructionDao;
import ir.maktab.model.entity.Instruction;
import ir.maktab.model.entity.Offer;
import ir.maktab.model.enumeration.InstructionStatus;
import ir.maktab.model.enumeration.OfferStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Set;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class InstructionService {
    private final InstructionDao instructionDao;

    public void save(Instruction instruction) {
        instructionDao.save(instruction);
    }

    public Instruction get(Integer id) {
        return instructionDao.findById(id);
    }

    public Offer findAcceptedOfferOfInstruction(Instruction instruction) {
        Offer acceptedOffer = null;
        if (instruction.getOrderStatus().equals(InstructionStatus.PAID)) {
            Set<Offer> offers = instruction.getOffers();
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
