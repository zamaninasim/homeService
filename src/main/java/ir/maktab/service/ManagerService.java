package ir.maktab.service;

import ir.maktab.dao.ManagerDao;
import ir.maktab.model.entity.users.Manager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class ManagerService {
    private final ManagerDao managerDao;

    public void save(Manager manager) {
        managerDao.save(manager);
    }

    public Boolean isManagerExist(String username) {
        Boolean exist = false;
        Optional<Manager> manager = managerDao.findByUsername(username);
        if (manager.isPresent()) {
            exist = true;
        } else {
            throw new RuntimeException("username not exist!");
        }
        return exist;
    }

    public Manager findByUsername(String username) {
        Optional<Manager> manager = managerDao.findByUsername(username);
        if (manager.isPresent()) {
            Manager foundedManager = manager.get();
            return foundedManager;
        } else {
            throw new RuntimeException("username not exist!");
        }
    }
}
