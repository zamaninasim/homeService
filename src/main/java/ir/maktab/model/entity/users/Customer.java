package ir.maktab.model.entity.users;

import ir.maktab.model.entity.Instruction;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Customer extends User {
    @OneToMany(mappedBy = "customer")
    private List<Instruction> instruction;

    @Override
    public String toString() {
        return super.toString();
    }
}
