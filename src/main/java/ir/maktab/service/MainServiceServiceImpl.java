package ir.maktab.service;

import ir.maktab.data.dao.MainServiceRepository;
import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.dto.MainServiceDto;
import ir.maktab.service.exception.EntityIsExistException;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainServiceServiceImpl implements MainServiceService {
    private final MainServiceRepository mainServiceRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(MainServiceDto mainServiceDto) {
        MainService mainService = modelMapper.map(mainServiceDto, MainService.class);
        Optional<MainService> foundedMainService = mainServiceRepository.findByName(mainService.getName());
        if (foundedMainService.isPresent()) {
            throw new EntityIsExistException("this mainService exist!");
        } else {
            mainServiceRepository.save(mainService);
        }
    }

    @Override
    public MainServiceDto findByName(String name) {
        Optional<MainService> optionalMainService = mainServiceRepository.findByName(name);
        MainService mainService = optionalMainService.orElseThrow(() -> new EntityNotExistException("this mainService not exist!"));
        return modelMapper.map(mainService, MainServiceDto.class);
    }
}
