package ir.maktab.dao;

import ir.maktab.model.entity.users.Manager;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ManagerDao {
    private final SessionFactory sessionFactory;

    public void save(Manager manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manager);
        transaction.commit();
        session.close();
    }

    public Optional<Manager> findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Manager> query = session.createQuery("FROM Manager manager WHERE manager.username=:usernameValue");
        query.setParameter("usernameValue", username);
        Optional<Manager> mainService = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return mainService;
    }
}
