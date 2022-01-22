package ir.maktab.service;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;

import java.util.List;

public interface SubServiceService {

    public void save(SubServiceDto subServiceDto);

    public void update(SubServiceDto subServiceDto);

    public SubServiceDto findByName(String name);

    public List<SubServiceDto> findAll();

    public SubServiceDto addExpertToSubService(ExpertDto expertDto, SubServiceDto subServiceDto);

    public SubServiceDto removeExpertFromSubService(ExpertDto expertDto, SubServiceDto subServiceDto);

    public List<ExpertDto> findSubServiceExpertsBySubServiceName(String name);
}
