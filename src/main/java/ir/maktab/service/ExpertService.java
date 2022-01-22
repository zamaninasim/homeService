package ir.maktab.service;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;

import java.util.List;

public interface ExpertService {

    public void save(ExpertDto expertDto);

    public ExpertDto findByEmailAddress(String emailAddress);

    public void update(ExpertDto expertDto);

    public List<SubServiceDto> findServicesByEmail(ExpertDto expertDto);

    public void updateScore(ExpertDto expertDto, Double instructionsScore);

    public ExpertDto findById(Integer id);
}
