package ir.maktab.service;

import ir.maktab.dao.SubServiceDao;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.validation.exception.ExistException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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
        }
        return false;
    }

    public SubService findByName(String name) {
        Optional<SubService> subService = subServiceDao.findByName(name);
        if (subService.isPresent()) {
            SubService foundedSubService = subService.get();
            return foundedSubService;
        }
        throw new ExistException("this subService exist!");
    }

    public List<SubService> findAll() {
        return subServiceDao.findAll();
    }
}
