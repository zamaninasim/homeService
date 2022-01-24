package ir.maktab.service;

import ir.maktab.data.dao.MainServiceRepository;
import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.dto.MainServiceDto;
import ir.maktab.dto.mapper.MainServiceMapper;
import ir.maktab.service.exception.MainServiceIsExistException;
import ir.maktab.service.exception.MainServiceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MainServiceServiceImpl implements MainServiceService {
    private final MainServiceRepository mainServiceRepository;
    private final MainServiceMapper mainServiceMapper;

    @Override
    public void save(MainServiceDto mainServiceDto) {
        MainService mainService = mainServiceMapper.getMainServiceWithOutId(mainServiceDto);
        Optional<MainService> foundedMainService = mainServiceRepository.findByName(mainService.getName());
        if (foundedMainService.isPresent()) {
            throw new MainServiceIsExistException();
        } else {
            mainServiceRepository.save(mainService);
        }
    }

    @Override
    public MainServiceDto findByName(String name) {
        Optional<MainService> optionalMainService = mainServiceRepository.findByName(name);
        MainService mainService = optionalMainService.orElseThrow(() -> new MainServiceNotFoundException());
        return mainServiceMapper.getMainServiceDto(mainService);
    }

    @Override
    public List<MainServiceDto> findAll() {
        List<MainService> mainServices = mainServiceRepository.findAll();
        return mainServices.stream().map(mainService -> mainServiceMapper.getMainServiceDto(mainService)).collect(Collectors.toList());
    }
}
