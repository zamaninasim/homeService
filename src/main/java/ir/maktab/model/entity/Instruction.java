package ir.maktab.model.entity;

import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Customer;
import ir.maktab.model.enumeration.OrderStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private SubService subService;
    private Long proposedPrice;
    private String jobDescription;
    @CreationTimestamp
    private Date orderRegistrationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfWorkPerformed;
    private String address;
    @ManyToOne
    private Customer customer;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "instruction")
    private Set<Offer> suggestions;
}
