package ir.maktab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubServiceDto {
    private Integer IdentificationNumber;
    private String name;
    private String basePrice;
    private String description;
    private String mainServiceName;
}
