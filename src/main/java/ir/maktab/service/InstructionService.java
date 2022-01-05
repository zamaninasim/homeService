package ir.maktab.service;

import ir.maktab.dao.InstructionDao;
import ir.maktab.model.entity.Instruction;
import ir.maktab.model.entity.users.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class InstructionService {
    private final InstructionDao instructionDao;

    public void save(Instruction instruction) {
        instructionDao.save(instruction);
    }

    public Instruction get(Integer id) {
        return instructionDao.get(id);
    }

    public List<Instruction> findByCustomer(Customer customer) {
        return instructionDao.findByCustomer(customer);
    }
}
