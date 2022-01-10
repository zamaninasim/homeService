package ir.maktab.service;

import ir.maktab.data.dao.MainServiceRepository;
import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainServiceService {
    private final MainServiceRepository mainServiceRepository;

    public MainService save(MainService mainService) {
        Optional<MainService> foundedMainService = mainServiceRepository.findByName(mainService.getName());
        if (foundedMainService.isPresent()) {
            throw new EntityIsExistException("this mainService exist!");
        } else {
            MainService savedMainService = mainServiceRepository.save(mainService);
            return savedMainService;
        }
    }

    public MainService findByName(String name) {
        Optional<MainService> mainService = mainServiceRepository.findByName(name);
        if (mainService.isPresent()) {
            return mainService.get();
        } else {
            throw new EntityNotExistException("this mainService not exist!");
        }
    }
}
