package ir.maktab.service;

import ir.maktab.data.dao.ExpertRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.mapper.SubServiceMapper;
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
public class ExpertService {
    private final ExpertRepository expertRepository;
    private final SubServiceMapper subServiceMapper;

    public void save(Expert expert) {
        Optional<Expert> foundedExpert = expertRepository.findByEmailAddress(expert.getEmailAddress());
        if (foundedExpert.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            expertRepository.save(expert);
        }
    }

    public Expert findByEmailAddress(String emailAddress) {
        Optional<Expert> expert = expertRepository.findByEmailAddress(emailAddress);
        return expert.orElseThrow(() -> new EntityNotExistException("emailAddress not exist!"));
    }

    public void update(Expert expert) {
        expertRepository.save(expert);
    }

    //TODO by expert
    public List<SubServiceDto> findServicesByEmail(String emailAddress) {
        Expert expert = findByEmailAddress(emailAddress);
        Set<SubService> services = expert.getServices();
        List<SubServiceDto> serviceDtos = services.stream().map(subServiceMapper::subServiceToSubServiceDto).collect(Collectors.toList());
        return serviceDtos;
    }

    public void updateScore(Expert expert, Double instructionsScore) {
        Double expertScore = expert.getScore();
        Double newScore = (expertScore + instructionsScore) / 2;
        expert.setScore(newScore);
        update(expert);
    }
}
