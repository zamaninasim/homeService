package ir.maktab.service;

import ir.maktab.dao.MainServiceDao;
import ir.maktab.exception.NotExistException;
import ir.maktab.model.entity.services.MainService;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class MainServiceService {
    private MainServiceDao mainServiceDao;

    public void save(MainService mainService) {
        mainServiceDao.save(mainService);
    }

    public void isMainServiceExist(String name) {
        Optional<MainService> mainService = mainServiceDao.findByName(name);
        if (!mainService.isPresent()) {
            throw new NotExistException("this mainService not exist!");
        }
    }
}
