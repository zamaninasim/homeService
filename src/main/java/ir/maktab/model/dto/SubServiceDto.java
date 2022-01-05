package ir.maktab.model.dto;

import ir.maktab.model.entity.services.MainService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubServiceDto {
    private String name;
    private Long basePrice;
    private String description;
    private MainService mainService;
}
