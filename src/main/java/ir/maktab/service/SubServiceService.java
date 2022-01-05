package ir.maktab.service;

import ir.maktab.dao.SubServiceDao;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.validation.exception.ExistException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class SubServiceService {
    private final SubServiceDao subServiceDao;

    public void save(SubService subService) {
        subServiceDao.save(subService);
    }

    public void update(SubService subService) {
        subServiceDao.update(subService);
    }

    public boolean isSubServiceExist(String name) {
        List<SubService> subServices = subServiceDao.findByName(name);
        if (!subServices.isEmpty()) {
            throw new ExistException("this subService exist!");
        }
        return false;
    }

    public SubService findByName(String name) {
        List<SubService> subServices = subServiceDao.findByName(name);
        SubService subService = subServices.get(0);
        return subService;
    }

    public List<SubService> findAll() {
        return subServiceDao.findAll();
    }
}
