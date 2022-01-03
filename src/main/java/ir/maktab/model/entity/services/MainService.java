package ir.maktab.model.entity.services;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
   @OneToMany
    private Set<SubService> subServices;
}
