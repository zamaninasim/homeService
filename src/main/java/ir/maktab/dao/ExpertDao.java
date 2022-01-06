package ir.maktab.dao;

import ir.maktab.model.entity.users.Expert;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExpertDao {
    private final SessionFactory sessionFactory;

    public void save(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expert);
        transaction.commit();
        session.close();
    }

    public Optional<Expert> findByEmailAddress(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Expert> query = session.createQuery("FROM Expert expert WHERE expert.emailAddress=:emailValue");
        query.setParameter("emailValue", email);
        Optional<Expert> expert = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return expert;
    }

    public void update(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();
    }
}
