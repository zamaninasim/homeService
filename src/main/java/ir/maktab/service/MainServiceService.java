package ir.maktab.service;

import ir.maktab.dao.MainServiceDao;
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
        mainServiceDao.save(mainService);
    }

    public MainService findMainService(String name) {
        Optional<MainService> mainService = mainServiceDao.findByName(name);
        if (mainService.isPresent()) {
            return mainService.get();
        } else {
            throw new NotExistException("this mainService not exist!");
        }
    }
}
