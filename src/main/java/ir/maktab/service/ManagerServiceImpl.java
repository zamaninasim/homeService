package ir.maktab.service;

import ir.maktab.data.dao.ManagerRepository;
import ir.maktab.data.model.entity.users.Manager;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.exception.ManagerNotFoundException;
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
    public ManagerDto findByEmailAddressAndPassword(String email, String password) {
        Optional<Manager> optionalManager = managerRepository.findByEmailAddressAndPassword(email, password);
        Manager manager = optionalManager.orElseThrow(() -> new ManagerNotFoundException());
        return modelMapper.map(manager, ManagerDto.class);
    }
}
