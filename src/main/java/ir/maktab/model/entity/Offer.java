package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.enumeration.OfferStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

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
}
