package ir.maktab.data.dao;

import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.data.model.entity.services.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Integer> {
    Optional<SubService> findByName(String name);
    List<SubService> findByMainService(MainService mainService);
}
