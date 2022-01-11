package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.Offer;
import ir.maktab.dto.OfferDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    private ExpertMapper expertMapper;
    private OrderMapper orderMapper;

    @Autowired
    public OfferMapper(ExpertMapper expertMapper, OrderMapper orderMapper) {
        this.expertMapper = expertMapper;
        this.orderMapper = orderMapper;
    }

    public OfferDto offerToOfferDto(Offer offer) {
        return OfferDto.builder()
                .identificationNumber((offer.getId()) + 1000L)
                .expertDto(expertMapper.expertToExpertDto(offer.getExpert()))
                .orderDto(orderMapper.orderToOrderDto(offer.getOrder()))
                .registrationDate(offer.getRegistrationDate())
                .proposedPrice(offer.getProposedPrice())
                .durationOfWork(offer.getDurationOfWork())
                .startTime(offer.getStartTime())
                .offerStatus(offer.getOfferStatus())
                .build();
    }

    public Offer offerDtoToOffer(OfferDto offerDto) {
        return Offer.builder()
                .id((int) ((offerDto.getIdentificationNumber()) - 1000))
                .expert(expertMapper.expertDtoToExpert(offerDto.getExpertDto()))
                .order(orderMapper.orderDtoToOrder(offerDto.getOrderDto()))
                .registrationDate(offerDto.getRegistrationDate())
                .proposedPrice(offerDto.getProposedPrice())
                .durationOfWork(offerDto.getDurationOfWork())
                .startTime(offerDto.getStartTime())
                .offerStatus(offerDto.getOfferStatus())
                .build();
    }
}
