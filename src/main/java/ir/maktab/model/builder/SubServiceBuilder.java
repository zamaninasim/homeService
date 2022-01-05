package ir.maktab.model.builder;

import ir.maktab.model.entity.services.MainService;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Expert;

import java.util.Set;

public final class SubServiceBuilder {
    private Integer id;
    private String name;
    private Long basePrice;
    private String description;
    private MainService mainService;
    private Set<Expert> experts;

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

    public SubServiceBuilder withExperts(Set<Expert> experts) {
        this.experts = experts;
        return this;
    }

    public SubService build() {
        SubService subService = new SubService();
        subService.setId(id);
        subService.setName(name);
        subService.setBasePrice(basePrice);
        subService.setDescription(description);
        subService.setMainService(mainService);
        subService.setExperts(experts);
        return subService;
    }
}
