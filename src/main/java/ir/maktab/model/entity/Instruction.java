package ir.maktab.model.entity;

import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Customer;
import ir.maktab.model.enumeration.InstructionStatus;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
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
    private InstructionStatus orderStatus;
    @OneToMany(mappedBy = "instruction",fetch = FetchType.EAGER)
    private Set<Offer> offers;

    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", proposedPrice=" + proposedPrice +
                ", jobDescription='" + jobDescription + '\'' +
                ", orderRegistrationDate=" + orderRegistrationDate +
                ", dateOfWorkPerformed=" + dateOfWorkPerformed +
                ", address='" + address + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return Objects.equals(id, that.id) && Objects.equals(proposedPrice, that.proposedPrice) && Objects.equals(jobDescription, that.jobDescription) && Objects.equals(orderRegistrationDate, that.orderRegistrationDate) && Objects.equals(dateOfWorkPerformed, that.dateOfWorkPerformed) && Objects.equals(address, that.address) && orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proposedPrice, jobDescription, orderRegistrationDate, dateOfWorkPerformed, address, orderStatus);
    }
}
