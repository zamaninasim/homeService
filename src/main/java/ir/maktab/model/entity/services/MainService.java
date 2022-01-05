package ir.maktab.model.entity.services;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "mainService")
    private Set<SubService> subServices;

    @Override
    public String toString() {
        return "MainService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
