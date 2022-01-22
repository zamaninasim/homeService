package ir.maktab.service;

import ir.maktab.data.dao.ExpertRepository;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.exception.EntityIsExistException;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpertServiceImpl implements ExpertService {
    private final ExpertRepository expertRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(ExpertDto expertDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        Optional<Expert> foundedExpert = expertRepository.findByEmailAddress(expert.getEmailAddress());
        if (foundedExpert.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            expertRepository.save(expert);
        }
    }

    @Override
    public ExpertDto findByEmailAddress(String emailAddress) {
        Optional<Expert> optionalExpert = expertRepository.findByEmailAddress(emailAddress);
        Expert expert = optionalExpert.orElseThrow(() -> new EntityNotExistException("emailAddress not exist!"));
        return modelMapper.map(expert, ExpertDto.class);
    }

    @Override
    public void update(ExpertDto expertDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        expertRepository.save(expert);
    }

    @Override
    public List<SubServiceDto> findServicesByEmail(ExpertDto expertDto) {
        Expert expert = modelMapper.map(expertDto, Expert.class);
        Set<SubService> services = expert.getServices();
        return services.stream()
                .map(subService -> modelMapper.map(subService, SubServiceDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updateScore(ExpertDto expertDto, Double instructionsScore) {
        Double expertScore = expertDto.getScore();
        Double newScore = (expertScore + instructionsScore) / 2;
        expertDto.setScore(newScore);
        update(expertDto);
    }

    @Override
    public ExpertDto findById(Integer id) {
        Optional<Expert> optionalExpert = expertRepository.findById(id);
        Expert expert = optionalExpert.orElseThrow(() -> new EntityNotExistException("expert not exist!"));
        return modelMapper.map(expert, ExpertDto.class);
    }
}
