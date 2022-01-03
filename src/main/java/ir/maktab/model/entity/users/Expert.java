package ir.maktab.model.entity.users;

import ir.maktab.model.entity.services.SubService;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.Set;
@Data
@Entity
public class Expert extends User {
    @Lob
    @Column(columnDefinition="BLOB")
    private byte[] photo;
    private Double score;
    @ManyToMany
    private Set<SubService> services;
}
