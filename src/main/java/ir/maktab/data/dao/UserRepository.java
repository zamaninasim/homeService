package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.User;
import ir.maktab.dto.UserDto;
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

    static Specification<User> selectByCondition(UserDto userDto) {
        return (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (userDto.getFirstname() != null) {
                predicates.add(cb.equal(root.get("firstname"), userDto.getFirstname()));
            }
            if (userDto.getLastname() != null) {
                predicates.add(cb.equal(root.get("lastname"), userDto.getLastname()));
            }
            if (userDto.getEmailAddress() != null) {
                predicates.add(cb.equal(root.get("emailAddress"), userDto.getEmailAddress()));
            }
            if (userDto.getRole() != null) {
                predicates.add(cb.equal(root.get("role"), userDto.getRole()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
