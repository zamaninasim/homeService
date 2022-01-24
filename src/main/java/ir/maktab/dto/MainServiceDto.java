package ir.maktab.dto;

import ir.maktab.service.validation.OnRegister;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainServiceDto {
    private Integer IdentificationNumber;
    @Pattern(regexp = "[a-zA-Z]{3,30}", message = "invalid name.", groups = {OnRegister.class})
    private String name;
}
