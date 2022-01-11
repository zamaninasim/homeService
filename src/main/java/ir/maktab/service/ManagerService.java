package ir.maktab.service;

import ir.maktab.data.dao.ManagerRepository;
import ir.maktab.data.model.entity.users.Manager;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerRepository managerRepository;

    public void save(Manager manager) {
        managerRepository.save(manager);
    }

    public Manager findByUsername(String username) {
        Optional<Manager> manager = managerRepository.findByUsername(username);
        return manager.orElseThrow(() -> new EntityNotExistException("username not exist!"));
    }
}
