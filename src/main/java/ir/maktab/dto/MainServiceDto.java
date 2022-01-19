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
public class MainServiceDto {
    private String name;
    private Set<SubServiceDto> subServices = new HashSet<>();
}
