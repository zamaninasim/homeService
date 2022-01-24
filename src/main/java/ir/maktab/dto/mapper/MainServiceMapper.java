package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.dto.MainServiceDto;
import org.springframework.stereotype.Component;


@Component
public class MainServiceMapper {
    static final Integer randomNumber = (int) ((Math.random() * (100 - 50)) + 50);

    public MainServiceDto getMainServiceDto(MainService mainService) {
        return MainServiceDto.builder()
                .IdentificationNumber(mainService.getId() + randomNumber)
                .name(mainService.getName())
                .build();
    }

    public MainService getMainService(MainServiceDto mainServiceDto) {
        return MainService.builder()
                .id(mainServiceDto.getIdentificationNumber() - randomNumber)
                .name(mainServiceDto.getName())
                .build();
    }

    public MainService getMainServiceWithOutId(MainServiceDto mainServiceDto) {
        return MainService.builder()
                .name(mainServiceDto.getName())
                .build();
    }
}
