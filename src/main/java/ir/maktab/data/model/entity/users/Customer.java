package ir.maktab.data.model.entity.users;

import ir.maktab.data.model.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {
    @OneToMany(mappedBy = "customer")
    private List<Order> instruction;

    @Override
    public String toString() {
        return super.toString();
    }
}
