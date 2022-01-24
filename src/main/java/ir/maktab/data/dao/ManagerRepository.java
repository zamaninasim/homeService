package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {
    Optional<Manager> findByEmailAddressAndPassword(String email, String password);
}
