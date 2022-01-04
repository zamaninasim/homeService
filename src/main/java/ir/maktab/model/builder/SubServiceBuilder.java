package ir.maktab.model.builder;

import ir.maktab.model.entity.services.MainService;
import ir.maktab.model.entity.services.SubService;

public final class SubServiceBuilder {
    private Integer id;
    private String name;
    private Long basePrice;
    private String description;
    private MainService mainService;

    private SubServiceBuilder() {
    }

    public static SubServiceBuilder aSubService() {
        return new SubServiceBuilder();
    }

    public SubServiceBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public SubServiceBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SubServiceBuilder withBasePrice(Long basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public SubServiceBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public SubServiceBuilder withMainService(MainService mainService) {
        this.mainService = mainService;
        return this;
    }

    public SubService build() {
        SubService subService = new SubService();
        subService.setId(id);
        subService.setName(name);
        subService.setBasePrice(basePrice);
        subService.setDescription(description);
        subService.setMainService(mainService);
        return subService;
    }
}
