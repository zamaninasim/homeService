package ir.maktab.service;

import ir.maktab.data.dao.SubServiceRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.mapper.SubServiceMapper;
import ir.maktab.service.exception.EntityIsExistException;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SubServiceServiceImpl implements SubServiceService {
    private final SubServiceRepository subServiceRepository;
    private final MainServiceService mainServiceService;
    private final SubServiceMapper subServiceMapper;
    private final ModelMapper modelMapper;

    @Override
    public void save(SubServiceDto subServiceDto) {
        SubService subService = subServiceMapper.getSubServiceWithOutId(subServiceDto);
        mainServiceService.findByName(subService.getMainService().getName());
        Optional<SubService> foundedSubService = subServiceRepository.findByName(subService.getName());
        if (foundedSubService.isPresent()) {
            throw new EntityIsExistException("this subService exist!");
        } else {
            subServiceRepository.save(subService);
        }
    }

    @Override
    public void update(SubServiceDto subServiceDto) {
        SubService subService = subServiceMapper.getSubService(subServiceDto);
        subServiceRepository.save(subService);
    }

    @Override
    public SubServiceDto findByName(String name) {
        Optional<SubService> optionalSubService = subServiceRepository.findByName(name);
        SubService subService = optionalSubService.orElseThrow(() -> new EntityNotExistException("this subService not exist!"));
        return subServiceMapper.getSubServiceDto(subService);
    }

    @Override
    public List<SubServiceDto> findAll() {
        List<SubService> subServices = subServiceRepository.findAll();
        return subServices.stream().map(subService -> subServiceMapper.getSubServiceDto(subService)).collect(Collectors.toList());
    }

    @Override
    public SubServiceDto addExpertToSubService(ExpertDto expertDto, SubServiceDto subServiceDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        subService.getExperts().add(expert);
        SubServiceDto newSubServiceDto = modelMapper.map(subService, SubServiceDto.class);
        update(newSubServiceDto);
        return newSubServiceDto;
    }

    @Override
    public SubServiceDto removeExpertFromSubService(ExpertDto expertDto, SubServiceDto subServiceDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        subService.getExperts().remove(expert);
        SubServiceDto newSubServiceDto = modelMapper.map(subService, SubServiceDto.class);
        update(newSubServiceDto);
        return newSubServiceDto;
    }

    @Override
    public List<ExpertDto> findSubServiceExpertsBySubServiceName(String name) {
        SubServiceDto subServiceDto = findByName(name);
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        Set<Expert> experts = subService.getExperts();
        return experts.stream().map(expert -> modelMapper.map(expert, ExpertDto.class)).collect(Collectors.toList());
    }
}
