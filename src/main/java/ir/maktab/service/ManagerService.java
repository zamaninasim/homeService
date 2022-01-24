package ir.maktab.service;

import ir.maktab.dto.ManagerDto;

public interface ManagerService {

    void save(ManagerDto managerDto);

    ManagerDto findByEmailAddressAndPassword(String email, String password);
}
