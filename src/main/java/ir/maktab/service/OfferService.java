package ir.maktab.service;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;

import java.util.List;

public interface OfferService {

    public void save(OfferDto offerDto);

    public OrderDto addOfferToOrder(OfferDto offerDto);

    public List<OfferDto> findByOrder(OrderDto orderDto);

    public OfferDto findByOrderAndExpert(OrderDto orderDto, ExpertDto expertDto);
}
