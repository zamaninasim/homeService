package ir.maktab.model.entity.users;

import ir.maktab.model.entity.services.SubService;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Expert extends User {
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] photo;
    private Double score;
    @ManyToMany(mappedBy = "experts",fetch = FetchType.EAGER)
    private Set<SubService> services = new HashSet<>();

    @Override
    public String toString() {
        return "Expert{" +
                "photo=" + Arrays.toString(photo) +
                ", score=" + score +
                '}';
    }
}
