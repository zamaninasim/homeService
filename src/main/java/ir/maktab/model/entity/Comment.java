package ir.maktab.model.entity;

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
    @OneToOne
    private Instruction instruction;
}
