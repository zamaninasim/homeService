package ir.maktab.service;

import ir.maktab.dto.MainServiceDto;

import java.util.List;

public interface MainServiceService {

    void save(MainServiceDto mainServiceDto);

    MainServiceDto findByName(String name);

    List<MainServiceDto> findAll();
}
