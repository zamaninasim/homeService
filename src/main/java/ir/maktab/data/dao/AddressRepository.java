package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    Optional<Address> findByZipCode(Long zipCode);
}
