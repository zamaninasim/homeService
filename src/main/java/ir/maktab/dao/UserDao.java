package ir.maktab.dao;

import ir.maktab.model.entity.users.User;
import ir.maktab.model.enumeration.Role;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.query.Query;

import java.util.List;
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

    public List<User> findUserByCondition(String firstname, String lastname, String email, Role role) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class, "u");
        if (firstname != null) {
            criteria.add(Restrictions.eq("u.firstname", firstname));
        }
        if (lastname != null) {
            criteria.add(Restrictions.eq("u.lastname", lastname));
        }
        if (email != null) {
            criteria.add(Restrictions.eq("u.emailAddress", email));
        }
        if (role != null) {
            criteria.add(Restrictions.eq("u.role", role));
        }
        List<User> users = criteria.list();
        transaction.commit();
        session.close();
        return users;
    }
}
