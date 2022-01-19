package ir.maktab.dto;

import ir.maktab.data.model.enumeration.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OfferDto {
    private ExpertDto expert;
    private OrderDto order;
    private Date registrationDate;
    private Long proposedPrice;
    private int durationOfWork;
    private Date startTime;
    private OfferStatus offerStatus;
    private String trackingCode;
}
