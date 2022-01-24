package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.dto.MainServiceDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.MainServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubServiceMapper {
    private final MainServiceService mainServiceService;
    private final MainServiceMapper mainServiceMapper;
    static final Integer randomNumber = (int) ((Math.random() * (100 - 50)) + 50);

    public SubServiceDto getSubServiceDto(SubService subService) {
        return SubServiceDto.builder()
                .IdentificationNumber(subService.getId() + randomNumber)
                .name(subService.getName())
                .basePrice(String.valueOf(subService.getBasePrice()))
                .description(subService.getDescription())
                .mainServiceName(subService.getMainService().getName())
                .build();
    }

    public SubService getSubService(SubServiceDto subServiceDto) {
        MainServiceDto MainServiceDto = mainServiceService.findByName(subServiceDto.getMainServiceName());
        MainService mainService = mainServiceMapper.getMainService(MainServiceDto);
        return SubService.builder()
                .id(subServiceDto.getIdentificationNumber() - randomNumber)
                .name(subServiceDto.getName())
                .basePrice(Long.parseLong(subServiceDto.getBasePrice()))
                .description(subServiceDto.getDescription())
                .mainService(mainService)
                .build();
    }
    public SubService getSubServiceWithOutId(SubServiceDto subServiceDto) {
        MainServiceDto MainServiceDto = mainServiceService.findByName(subServiceDto.getMainServiceName());
        MainService mainService = mainServiceMapper.getMainService(MainServiceDto);
        return SubService.builder()
                .name(subServiceDto.getName())
                .basePrice(Long.parseLong(subServiceDto.getBasePrice()))
                .description(subServiceDto.getDescription())
                .mainService(mainService)
                .build();
    }
}
