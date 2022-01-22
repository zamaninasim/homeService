package ir.maktab.service;

import ir.maktab.dto.MainServiceDto;

public interface MainServiceService {

    public void save(MainServiceDto mainServiceDto);

    public MainServiceDto findByName(String name);
}
