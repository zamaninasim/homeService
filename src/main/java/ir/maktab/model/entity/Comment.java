package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Customer;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double score;
    @Lob
    private String opinion;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Instruction order;
}
