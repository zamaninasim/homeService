package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.enumeration.OfferStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private Instruction instruction;
    @CreationTimestamp
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", registrationDate=" + registrationDate +
                ", proposedPrice=" + proposedPrice +
                ", durationOfWork=" + durationOfWork +
                ", startTime=" + startTime +
                ", offerStatus=" + offerStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return durationOfWork == offer.durationOfWork && Objects.equals(id, offer.id) && Objects.equals(expert, offer.expert) && Objects.equals(instruction, offer.instruction) && Objects.equals(registrationDate, offer.registrationDate) && Objects.equals(proposedPrice, offer.proposedPrice) && Objects.equals(startTime, offer.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expert, instruction, registrationDate, proposedPrice, durationOfWork, startTime);
    }
}
