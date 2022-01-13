package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.Role;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    Optional<User> findByEmailAddress(String email);

    static Specification<User> selectByCondition(String firstname, String lastname, String email, Role role) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (firstname != null) {
                predicates.add(cb.equal(root.get("firstname"), firstname));
            }
            if (lastname != null) {
                predicates.add(cb.equal(root.get("lastname"), lastname));
            }
            if (email != null) {
                predicates.add(cb.equal(root.get("emailAddress"), email));
            }
            if (role != null) {
                predicates.add(cb.equal(root.get("role"), role));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
