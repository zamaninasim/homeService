package ir.maktab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubServiceDto {
    private String name;
    private Long basePrice;
    private String description;
    private MainServiceDto mainServiceDto;
    private Set<ExpertDto> experts = new HashSet<>();
}
