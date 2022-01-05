package ir.maktab.model.builder;

import ir.maktab.model.entity.Instruction;
import ir.maktab.model.entity.Offer;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.enumeration.OfferStatus;

import java.util.Date;

public final class OfferBuilder {
    private Integer id;
    private Expert expert;
    private Instruction instruction;
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    private Date startTime;
    private OfferStatus offerStatus;

    private OfferBuilder() {
    }

    public static OfferBuilder anOffer() {
        return new OfferBuilder();
    }

    public OfferBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public OfferBuilder withExpert(Expert expert) {
        this.expert = expert;
        return this;
    }

    public OfferBuilder withInstruction(Instruction instruction) {
        this.instruction = instruction;
        return this;
    }

    public OfferBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public OfferBuilder withProposedPrice(Long proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public OfferBuilder withDurationOfWork(int durationOfWork) {
        this.durationOfWork = durationOfWork;
        return this;
    }

    public OfferBuilder withStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public OfferBuilder withOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
        return this;
    }

    public Offer build() {
        Offer offer = new Offer();
        offer.setId(id);
        offer.setExpert(expert);
        offer.setInstruction(instruction);
        offer.setRegistrationDate(registrationDate);
        offer.setProposedPrice(proposedPrice);
        offer.setDurationOfWork(durationOfWork);
        offer.setStartTime(startTime);
        offer.setOfferStatus(offerStatus);
        return offer;
    }
}
