package ir.maktab.dao;

import ir.maktab.model.entity.users.User;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class UserDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public Optional<User> findByEmailAddress(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<User> query = session.createQuery("FROM User user WHERE user.emailAddress=:emailValue");
        query.setParameter("emailValue", email);
        Optional<User> user = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return user;
    }
}
