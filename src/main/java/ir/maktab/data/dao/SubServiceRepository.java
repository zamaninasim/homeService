package ir.maktab.data.dao;

import ir.maktab.data.model.entity.services.SubService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubServiceRepository extends CrudRepository<SubService, Integer> {
    Optional<SubService> findByName(String name);
}
