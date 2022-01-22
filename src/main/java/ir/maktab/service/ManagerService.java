package ir.maktab.service;

import ir.maktab.dto.ManagerDto;

public interface ManagerService {

    public void save(ManagerDto managerDto);

    public ManagerDto findByUsername(String username);
}
