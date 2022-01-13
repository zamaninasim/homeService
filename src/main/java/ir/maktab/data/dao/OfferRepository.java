package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.users.Expert;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends PagingAndSortingRepository<Offer, Integer> {
    List<Offer> findByOrder(Order order, Sort var1);
    Optional<Offer> findByOrderAndExpert(Order order, Expert expert);
}
