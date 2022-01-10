package ir.maktab.service;

import ir.maktab.data.dao.ManagerRepository;
import ir.maktab.data.model.entity.users.Manager;
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

    public Boolean isManagerExist(String username) {
        Boolean exist = false;
        Optional<Manager> manager = managerRepository.findByUsername(username);
        if (manager.isPresent()) {
            exist = true;
        } else {
            throw new RuntimeException("username not exist!");
        }
        return exist;
    }

    public Manager findByUsername(String username) {
        Optional<Manager> manager = managerRepository.findByUsername(username);
        if (manager.isPresent()) {
            Manager foundedManager = manager.get();
            return foundedManager;
        } else {
            throw new RuntimeException("username not exist!");
        }
    }
}
