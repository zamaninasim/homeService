package ir.maktab.data.model.entity.users;

import ir.maktab.data.model.entity.services.SubService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Expert extends User {
    @Lob
    @Column(columnDefinition = "BLOB",length = 300000)
    private byte[] photo;
    private Double score;
    @ManyToMany(mappedBy = "experts",fetch = FetchType.EAGER)
    private Set<SubService> services = new HashSet<>();

    @Override
    public String toString() {
        return super.toString() +
                "score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Expert expert = (Expert) o;
        return Arrays.equals(photo, expert.photo) && Objects.equals(score, expert.score) && Objects.equals(services, expert.services);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), score, services);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
