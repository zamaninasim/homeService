package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.Role;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {
    EntityManager em;

    @Override
    public List<User> findUserByCondition(String firstname, String lastname, String email, Role role) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if (firstname != null) {
            predicates.add(cb.equal(user.get("firstname"), firstname));
        }
        if (lastname != null) {
            predicates.add(cb.equal(user.get("lastname"), lastname));
        }
        if (email != null) {
            predicates.add(cb.equal(user.get("emailAddress"), email));
        }
        if (role != null) {
            predicates.add(cb.equal(user.get("role"), role));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(cq).getResultList();
    }
}