package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Expert;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Expert expert;
    @CreationTimestamp
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
}
