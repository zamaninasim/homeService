package ir.maktab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDto extends UserDto {
    private byte[] photo;
    private Double score;
    private Set<SubServiceDto> services = new HashSet<>();
}
