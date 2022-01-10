package ir.maktab.dto;

import ir.maktab.data.model.entity.services.MainService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubServiceDto {
    private String name;
    private Long basePrice;
    private String description;
    private MainService mainService;
}
