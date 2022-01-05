package ir.maktab.service;

import ir.maktab.dao.OfferDao;
import ir.maktab.model.entity.Offer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferDao offerDao;

    public void save(Offer offer) {
        offerDao.save(offer);
    }
}
