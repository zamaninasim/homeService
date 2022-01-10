package ir.maktab.data.dao;

import ir.maktab.data.model.entity.services.MainService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainServiceRepository extends CrudRepository<MainService, Integer> {
    Optional<MainService> findByName(String name);
}
