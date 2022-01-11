package ir.maktab.service;

import ir.maktab.data.dao.SubServiceRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.mapper.ExpertMapper;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
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

    public SubService save(SubService subService) {
        mainServiceService.findByName(subService.getMainService().getName());
        Optional<SubService> foundedSubService = subServiceRepository.findByName(subService.getName());
        if (foundedSubService.isPresent()) {
            throw new EntityIsExistException("this subService exist!");
        } else {
            return subServiceRepository.save(subService);
        }
    }

    public SubService update(SubService subService) {
        return subServiceRepository.save(subService);
    }

    public SubService findByName(String name) {
        Optional<SubService> subService = subServiceRepository.findByName(name);
        return subService.orElseThrow(() -> new EntityNotExistException("this subService not exist!"));
    }

    public List<SubService> findAll() {
        List<SubService> subServices = new ArrayList<>();
        Iterable<SubService> subServiceIterable = subServiceRepository.findAll();
        subServiceIterable.forEach(subServices::add);
        return subServices;
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

    //TODO
    public List<ExpertDto> findExpertsByName(String name) {
        SubService subService = findByName(name);
        Set<Expert> experts = subService.getExperts();
        List<ExpertDto> expertDtos = experts.stream().map(expertMapper::expertToExpertDto).collect(Collectors.toList());
        return expertDtos;
    }
}
