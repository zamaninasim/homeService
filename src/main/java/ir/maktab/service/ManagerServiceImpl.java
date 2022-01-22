package ir.maktab.service;

import ir.maktab.data.dao.ManagerRepository;
import ir.maktab.data.model.entity.users.Manager;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(ManagerDto managerDto) {
        Manager manager = modelMapper.map(managerDto, Manager.class);
        managerRepository.save(manager);
    }

    @Override
    public ManagerDto findByUsername(String username) {
        Optional<Manager> optionalManager = managerRepository.findByUsername(username);
        Manager manager = optionalManager.orElseThrow(() -> new EntityNotExistException("username not exist!"));
        return modelMapper.map(manager, ManagerDto.class);
    }
}