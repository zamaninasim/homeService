package ir.maktab.service;

import ir.maktab.dao.MainServiceDao;
import ir.maktab.validation.exception.IsExistException;
import ir.maktab.validation.exception.NotExistException;
import ir.maktab.model.entity.services.MainService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class MainServiceService {
    private final MainServiceDao mainServiceDao;

    public void save(MainService mainService) {
        Optional<MainService> foundedMainService = mainServiceDao.findByName(mainService.getName());
        if (foundedMainService.isPresent()) {
            throw new IsExistException("this mainService exist!");
        } else {
            mainServiceDao.save(mainService);
            System.out.println("mainService "+mainService.getName()+" saved.");
        }

    }

    public MainService findByName(String name) {
        Optional<MainService> mainService = mainServiceDao.findByName(name);
        if (mainService.isPresent()) {
            return mainService.get();
        } else {
            throw new NotExistException("this mainService not exist!");
        }
    }
}
