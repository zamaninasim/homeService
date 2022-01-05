package ir.maktab.dao;

import ir.maktab.model.entity.Instruction;
import ir.maktab.model.entity.users.Customer;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InstructionDao {
    private final SessionFactory sessionFactory;

    public void save(Instruction instruction) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(instruction);
        transaction.commit();
        session.close();
    }

    public Instruction get(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Instruction instruction = session.get(Instruction.class, id);
        transaction.commit();
        session.close();
        return instruction;
    }

    public List<Instruction> findByCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Instruction> query = session.createQuery("FROM Instruction i WHERE i.customer=:customerValue");
        query.setParameter("customerValue", customer);
        List<Instruction> instructions = query.list();
        transaction.commit();
        session.close();
        return instructions;
    }
}
