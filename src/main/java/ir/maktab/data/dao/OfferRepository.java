package ir.maktab.data.dao;

import ir.maktab.data.model.entity.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Integer> {
}
