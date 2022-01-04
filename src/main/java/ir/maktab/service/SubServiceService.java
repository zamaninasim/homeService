package ir.maktab.service;

import ir.maktab.dao.SubServiceDao;
import ir.maktab.exception.ExistException;
import ir.maktab.model.entity.services.SubService;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class SubServiceService {
    private SubServiceDao subServiceDao;

    public void save(SubService subService) {
        subServiceDao.save(subService);
    }

    public boolean isSubServiceExist(String name) {
        Optional<SubService> subService = subServiceDao.findByName(name);
        if (subService.isPresent()) {
            throw new ExistException("this subService exist!");
        } else {
            return false;
        }
    }
}
