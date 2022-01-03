package ir.maktab.service;

import ir.maktab.dao.MainServiceDao;
import ir.maktab.model.entity.services.MainService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainServiceService {
    private MainServiceDao mainServiceDao;

    public void save(MainService mainService) {
        mainServiceDao.save(mainService);
    }
}
