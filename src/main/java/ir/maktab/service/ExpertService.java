package ir.maktab.service;

import ir.maktab.dao.ExpertDao;
import ir.maktab.model.dto.SubServiceDto;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.service.mapper.Mapper;
import ir.maktab.validation.exception.IsExistException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class ExpertService {
    private final ExpertDao expertDao;
    Mapper mapper = new Mapper();

    public void save(Expert expert) {
        Optional<Expert> foundedExpert = expertDao.findByEmailAddress(expert.getEmailAddress());
        if (foundedExpert.isPresent()) {
            throw new IsExistException("this emailAddress exist!");
        } else {
            expertDao.save(expert);
            System.out.println("expert whit '" + expert.getEmailAddress() + "' emailAddress saved.");
        }
    }

    public Expert findByEmailAddress(String emailAddress) {
        Optional<Expert> expert = expertDao.findByEmailAddress(emailAddress);
        if (expert.isPresent()) {
            Expert foundedExpert = expert.get();
            return foundedExpert;
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }
    }

    public boolean isExist(String emailAddress) {
        Optional<Expert> expert = expertDao.findByEmailAddress(emailAddress);
        if (expert.isPresent()) {
            throw new IsExistException("this emailAddress exist!");
        } else {
            return false;
        }
    }

    public void update(Expert expert) {
        expertDao.update(expert);
    }

    public List<SubServiceDto> findServicesByEmail(String emailAddress){
        Expert expert = findByEmailAddress("zamaninasim213@gmail.com");
        Set<SubService> services = expert.getServices();
        List<SubServiceDto> serviceDtos = services.stream().map(mapper::subServiceDto).collect(Collectors.toList());
        return serviceDtos;
    }
}
