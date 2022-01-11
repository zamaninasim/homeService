package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.dto.SubServiceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubServiceMapper {
    private final MainServiceMapper mainServiceMapper;

    public SubServiceDto subServiceToSubServiceDto(SubService subService) {
        return SubServiceDto.builder()
                .name(subService.getName())
                .basePrice(subService.getBasePrice())
                .description(subService.getDescription())
                .mainServiceDto(mainServiceMapper.mainServiceToMainServiceDto(subService.getMainService()))
                .build();
    }

    public SubService subServiceDtoToSubService(SubServiceDto subServiceDto) {
        return SubService.builder()
                .name(subServiceDto.getName())
                .basePrice(subServiceDto.getBasePrice())
                .description(subServiceDto.getDescription())
                .mainService(mainServiceMapper.mainServiceDtoToMainService(subServiceDto.getMainServiceDto()))
                .build();
    }
}
