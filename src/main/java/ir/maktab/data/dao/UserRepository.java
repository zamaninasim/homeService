package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {
    Optional<User> findByEmailAddress(String email);

    /*public List<User> findUserByCondition(String firstname, String lastname, String email, Role role) {
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
    }*/
}
