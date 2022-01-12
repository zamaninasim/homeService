package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.OfferStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OfferServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    OfferService offerService = context.getBean(OfferService.class);
    ExpertService expertService = context.getBean(ExpertService.class);
    OrderService orderService = context.getBean(OrderService.class);
    Offer offer;
    @Before
    public void init(){
        Order order = orderService.findById(5);
        Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        offer = Offer.builder()
                .expert(expert)
                .order(order)
                .proposedPrice(500000L)
                .durationOfWork(5)
                .startTime(startDate)
                .offerStatus(OfferStatus.UNCHECKED)
                .build();
    }

    @Test
    public void givenOffer_WhenAddOfferToOrder_ThenReturnOrder() {
        Order order = offerService.addOfferToOrder(offer);
        order.getOffers().forEach(System.out::println);
        assertTrue(order.getOffers().contains(offer));
    }
}
