package ir.maktab.service;

import ir.maktab.data.dao.SubServiceRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.mapper.ExpertMapper;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
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
public class SubServiceService {
    private final SubServiceRepository subServiceRepository;
    private final MainServiceService mainServiceService;
    private final ExpertMapper expertMapper;
    private final ModelMapper modelMapper;

    public void save(SubServiceDto subServiceDto) {
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        mainServiceService.findByName(subService.getMainService().getName());
        Optional<SubService> foundedSubService = subServiceRepository.findByName(subService.getName());
        if (foundedSubService.isPresent()) {
            throw new EntityIsExistException("this subService exist!");
        } else {
            subServiceRepository.save(subService);
        }
    }

    public void update(SubServiceDto subServiceDto) {
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        subServiceRepository.save(subService);
    }

    public SubServiceDto findByName(String name) {
        Optional<SubService> optionalSubService = subServiceRepository.findByName(name);
        SubService subService = optionalSubService.orElseThrow(() -> new EntityNotExistException("this subService not exist!"));
        return modelMapper.map(subService, SubServiceDto.class);
    }

    public List<SubServiceDto> findAll() {
        List<SubServiceDto> subServiceDtos = new ArrayList<>();
        Iterable<SubService> subServiceIterable = subServiceRepository.findAll();
        subServiceIterable.forEach(subService -> subServiceDtos.add(modelMapper.map(subService, SubServiceDto.class)));
        return subServiceDtos;
    }

    public SubServiceDto addExpertToSubService(ExpertDto expertDto, SubServiceDto subServiceDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        subService.getExperts().add(expert);
        SubServiceDto newSubServiceDto = modelMapper.map(subService, SubServiceDto.class);
        update(newSubServiceDto);
        return newSubServiceDto;
    }

    public SubServiceDto removeExpertFromSubService(ExpertDto expertDto, SubServiceDto subServiceDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        subService.getExperts().remove(expert);
        SubServiceDto newSubServiceDto = modelMapper.map(subService, SubServiceDto.class);
        update(newSubServiceDto);
        return newSubServiceDto;
    }

    public List<ExpertDto> findSubServiceExpertsBySubServiceName(String name) {
        SubServiceDto subServiceDto = findByName(name);
        SubService subService = modelMapper.map(subServiceDto, SubService.class);
        Set<Expert> experts = subService.getExperts();
        List<ExpertDto> expertDtos = experts.stream().map(expertMapper::expertToExpertDto).collect(Collectors.toList());
        return expertDtos;
    }
}
