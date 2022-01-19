package ir.maktab.dto;

import ir.maktab.data.model.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private SubServiceDto subService;
    private Long proposedPrice;
    private String jobDescription;
    private Date orderRegistrationDate;
    private Date dateOfWorkPerformed;
    private AddressDto address;
    private CustomerDto customer;
    private OrderStatus orderStatus;
    private Set<OfferDto> offers = new HashSet<>();
    private ExpertDto expert;
    private UUID trackingNumber;
}
