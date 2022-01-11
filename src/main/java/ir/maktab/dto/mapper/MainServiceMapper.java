package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.dto.MainServiceDto;
import org.springframework.stereotype.Component;

@Component
public class MainServiceMapper {
    public MainServiceDto mainServiceToMainServiceDto(MainService mainService) {
        return MainServiceDto.builder()
                .name(mainService.getName())
                .build();
    }

    public MainService mainServiceDtoToMainService(MainServiceDto mainServiceDto) {
        return MainService.builder()
                .name(mainServiceDto.getName())
                .build();
    }
}
