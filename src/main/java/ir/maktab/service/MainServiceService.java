package ir.maktab.service;

import ir.maktab.dao.MainServiceDao;
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

    public Boolean isMainServiceExist(String name) {
        Boolean exist = false;
        Optional<MainService> mainService = mainServiceDao.findByName(name);
        if (mainService.isPresent()) {
            exist=true;
        } else {
            throw new RuntimeException("this mainService not exist!");
        }
        return exist;
    }
}
