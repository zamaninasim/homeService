package ir.maktab.dao;

import ir.maktab.model.entity.Instruction;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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

    public void delete(Instruction instruction) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(instruction);
        transaction.commit();
        session.close();
    }

    public void update(Instruction instruction) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(instruction);
        transaction.commit();
        session.close();
    }

    public Instruction findById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Instruction instruction = session.get(Instruction.class, id);
        transaction.commit();
        session.close();
        return instruction;
    }
}
