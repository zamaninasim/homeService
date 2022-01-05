package ir.maktab.model.entity.services;

import ir.maktab.model.entity.users.Expert;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private Long basePrice;
    @Lob
    private String description;
    @ManyToOne
    private MainService mainService;
    @ManyToMany
    private Set<Expert> experts = new HashSet<>();

    @Override
    public String toString() {
        return "SubService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                ", description='" + description + '\'' +
                ", mainService=" + mainService +
                '}';
    }
}
