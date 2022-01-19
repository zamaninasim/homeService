package ir.maktab.dto;

import ir.maktab.data.model.entity.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class CustomerDto extends UserDto {
    private List<Order> orders;
}