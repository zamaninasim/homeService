package ir.maktab.data.dao;

import ir.maktab.data.model.entity.users.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
   Optional<Customer> findByEmailAddress(String email);
   Optional<Customer> findByEmailAddressAndPassword(String email,String password);
}
