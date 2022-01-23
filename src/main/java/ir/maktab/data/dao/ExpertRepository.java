package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.Expert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpertRepository extends CrudRepository<Expert, Integer> {
    Optional<Expert> findByEmailAddress(String email);
    Optional<Expert> findByEmailAddressAndPassword(String email,String password);
}
