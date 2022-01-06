package ir.maktab.dao;

import ir.maktab.model.entity.users.User;
import ir.maktab.model.enumeration.Role;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final SessionFactory sessionFactory;

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

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public User findById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }
}
