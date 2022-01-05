package ir.maktab.service;

import ir.maktab.dao.ExpertDao;
import ir.maktab.validation.exception.ExistException;
import ir.maktab.model.entity.users.Expert;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class ExpertService {
    private final ExpertDao expertDao;
    public void save(Expert expert) {
        expertDao.save(expert);
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
            throw new ExistException("this emailAddress exist!");
        } else {
            return false;
        }
    }
}
