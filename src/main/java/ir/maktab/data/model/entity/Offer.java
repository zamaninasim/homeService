package ir.maktab.data.model.entity;

import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private Order order;
    @CreationTimestamp
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
    private UUID trackingNumber = UUID.randomUUID();

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", registrationDate=" + registrationDate +
                ", proposedPrice=" + proposedPrice +
                ", durationOfWork=" + durationOfWork +
                ", startTime=" + startTime +
                ", offerStatus=" + offerStatus +
                ", expertScore=" + expert.getScore() +
                ", expert=" + expert.getFirstname() + " " + expert.getLastname() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return durationOfWork == offer.durationOfWork && Objects.equals(id, offer.id) && Objects.equals(expert, offer.expert) && Objects.equals(order, offer.order) && Objects.equals(registrationDate, offer.registrationDate) && Objects.equals(proposedPrice, offer.proposedPrice) && Objects.equals(startTime, offer.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expert, order, registrationDate, proposedPrice, durationOfWork, startTime);
    }
}
