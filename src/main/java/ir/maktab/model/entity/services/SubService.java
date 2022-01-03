package ir.maktab.model.entity.services;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long basePrice;
    @Lob
    private String description;
    @ManyToOne
    private MainService mainService;
}
