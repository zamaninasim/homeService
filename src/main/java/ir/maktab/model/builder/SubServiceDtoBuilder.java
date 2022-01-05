package ir.maktab.model.builder;

import ir.maktab.model.dto.SubServiceDto;
import ir.maktab.model.entity.services.MainService;

public final class SubServiceDtoBuilder {
    private String name;
    private Long basePrice;
    private String description;
    private MainService mainService;

    private SubServiceDtoBuilder() {
    }

    public static SubServiceDtoBuilder aSubServiceDto() {
        return new SubServiceDtoBuilder();
    }

    public SubServiceDtoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SubServiceDtoBuilder withBasePrice(Long basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public SubServiceDtoBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public SubServiceDtoBuilder withMainService(MainService mainService) {
        this.mainService = mainService;
        return this;
    }

    public SubServiceDto build() {
        SubServiceDto subServiceDto = new SubServiceDto();
        subServiceDto.setName(name);
        subServiceDto.setBasePrice(basePrice);
        subServiceDto.setDescription(description);
        subServiceDto.setMainService(mainService);
        return subServiceDto;
    }
}
