package ir.maktab.service;

import ir.maktab.dao.SubServiceDao;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.validation.exception.IsExistException;
import ir.maktab.validation.exception.NotExistException;
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
    private final MainServiceService mainServiceService;

    public void save(SubService subService) {
        List<SubService> subServices = subServiceDao.findByName(subService.getName());
        if (!subServices.isEmpty()) {
            throw new IsExistException("this subService exist!");
        } else {
            subServiceDao.save(subService);
            System.out.println("SubService " + subService.getName() + " saved.");
        }
    }

    public void update(SubService subService) {
        subServiceDao.update(subService);
    }

    public boolean isSubServiceExist(String name) {
        List<SubService> subServices = subServiceDao.findByName(name);
        if (!subServices.isEmpty()) {
            throw new IsExistException("this subService exist!");
        }
        return false;
    }

    public SubService findByName(String name) {
        List<SubService> subServices = subServiceDao.findByName(name);
        if (subServices.isEmpty()) {
            throw new NotExistException("this subService not exist!");
        }
        SubService subService = subServices.get(0);
        return subService;
    }

    public List<SubService> findAll() {
        return subServiceDao.findAll();
    }

    public void addExpertToSubService(Expert expert, SubService subService) {
        subService.getExperts().add(expert);
        update(subService);
        System.out.println("expert add successfully");
    }

    public void removeExpertFromSubService(Expert expert, SubService subService) {
        subService.getExperts().remove(expert);
        update(subService);
        System.out.println("expert remove successfully");
    }
}
