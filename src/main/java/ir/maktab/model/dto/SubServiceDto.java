package ir.maktab.model.dto;

import ir.maktab.model.entity.services.MainService;
import lombok.Data;

@Data
public class SubServiceDto {
    private String name;
    private Long basePrice;
    private String description;
    private MainService mainService;
}
