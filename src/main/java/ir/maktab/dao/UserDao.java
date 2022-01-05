package ir.maktab.dao;

import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.entity.users.User;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
