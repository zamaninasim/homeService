package ir.maktab.service;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;

import java.util.List;

public interface SubServiceService {

    void save(SubServiceDto subServiceDto);

    void update(SubServiceDto subServiceDto);

    SubServiceDto findByName(String name);

    List<SubServiceDto> findAll();

    public SubServiceDto addExpertToSubService(ExpertDto expertDto, SubServiceDto subServiceDto);

    public SubServiceDto removeExpertFromSubService(ExpertDto expertDto, SubServiceDto subServiceDto);

    public List<ExpertDto> findSubServiceExpertsBySubServiceName(String name);
}
