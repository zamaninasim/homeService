package ir.maktab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private String city;
    private String state;
    private String streetAddress;
    private String houseNumber;
    private Long zipCode;
}
