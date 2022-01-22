package ir.maktab.service;

import ir.maktab.dto.OrderDto;

public interface OrderService {

    public void save(OrderDto orderDto);

    public OrderDto findById(Integer id);
//TODO
/*    public Offer findAcceptedOfferOfOrder(Order order) {
        Offer acceptedOffer = null;
        if (order.getOrderStatus().equals(OrderStatus.PAID)) {
            Set<Offer> offers = order.getOffers();
            for (Offer offer : offers) {
                if (offer.getOfferStatus().equals(OfferStatus.ACCEPTED)) {
                    acceptedOffer = offer;
                }
            }
            return acceptedOffer;
        } else {
            throw new RuntimeException("Order not Paid!");
        }
    }*/
}
