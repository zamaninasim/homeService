package ir.maktab.service;

import ir.maktab.data.dao.SubServiceRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.mapper.Mapper;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SubServiceService {
    private final SubServiceRepository subServiceRepository;
    private final MainServiceService mainServiceService;
    private final Mapper mapper;

    public void save(SubService subService) {
        Optional<SubService> subService1 = subServiceRepository.findByName(subService.getName());
        if (subService1.isPresent()) {
            throw new EntityIsExistException("this subService exist!");
        } else {
            subServiceRepository.save(subService);
        }
    }

    public void update(SubService subService) {
        subServiceRepository.save(subService);
    }

    public boolean isSubServiceExist(String name) {
        Optional<SubService> subService = subServiceRepository.findByName(name);
        if (subService.isPresent()) {
            throw new EntityIsExistException("this subService exist!");
        }
        return false;
    }

    public SubService findByName(String name) {
        Optional<SubService> subService = subServiceRepository.findByName(name);
        if (subService.isPresent()) {
            SubService foundedSubService = subService.get();
            return foundedSubService;
        } else {
            throw new EntityNotExistException("this subService not exist!");
        }
    }

    //TODO iterable ro bekhonam
    public Iterable<SubService> findAll() {
        return subServiceRepository.findAll();
    }

    public void addExpertToSubService(Expert expert, SubService subService) {
        subService.getExperts().add(expert);
        update(subService);
        System.out.println("expert add successfully");
    }

    public void removeExpertFromSubService(Expert expert, SubService subService) {
        subService.getExperts().remove(expert);
        update(subService);
        System.out.println("expert remove successfully");
    }

    public List<ExpertDto> findExpertsByName(String name) {
        SubService subService = findByName(name);
        Set<Expert> experts = subService.getExperts();
        List<ExpertDto> expertDtos = experts.stream().map(mapper::expertDto).collect(Collectors.toList());
        return expertDtos;
    }
}
