package ir.maktab.service;

import ir.maktab.dao.SubServiceDao;
import ir.maktab.exception.NotExistException;
import ir.maktab.model.entity.services.MainService;
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

    public SubService isSubServiceExist(String name) {
        Optional<SubService> subService = subServiceDao.findByName(name);
        if (subService.isPresent()) {
            return subService.get();
        } else {
            throw new NotExistException("this subService not exist!");
        }
    }
}
