package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.OfferStatus;
import ir.maktab.exception.NotMatchException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class OfferServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    OfferService offerService = context.getBean(OfferService.class);
    ExpertService expertService = context.getBean(ExpertService.class);
    OrderService orderService = context.getBean(OrderService.class);
    Offer offer;

    @Test
    public void givenOffer_WhenAddOfferToOrder_ThenReturnOrder() {
        Order foundedOrder = orderService.findById(5);
        Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        offer = Offer.builder()
                .expert(expert)
                .order(foundedOrder)
                .proposedPrice(500000L)
                .durationOfWork(5)
                .startTime(startDate)
                .offerStatus(OfferStatus.UNCHECKED)
                .build();
        Order order = offerService.addOfferToOrder(offer);
        assertTrue(order.getOffers().contains(offer));
    }

    @Test
    public void givenOfferThatExpertNotHaveThatSubService_WhenAddOfferToOrder_ThenThrowException() {
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
        NotMatchException thrown = assertThrows(NotMatchException.class, () -> offerService.addOfferToOrder(offer));
        assertTrue(thrown.getMessage().contains("your offer is not match for this Order!"));
    }

    @Test
    public void givenOfferWhitProposedPriceLessThanBasePrice_WhenAddOfferToOrder_ThenThrowException() {
        Order order = orderService.findById(5);
        Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        offer = Offer.builder()
                .expert(expert)
                .order(order)
                .proposedPrice(1000L)
                .durationOfWork(5)
                .startTime(startDate)
                .offerStatus(OfferStatus.UNCHECKED)
                .build();
        NotMatchException thrown = assertThrows(NotMatchException.class, () -> offerService.addOfferToOrder(offer));
        assertTrue(thrown.getMessage().contains("your offer is not match for this Order!"));
    }

    @Test
    public void givenOrder_WhenFindByOrder_ThenReturnOffers() {
        Order order = orderService.findById(5);
        List<Offer> offers = offerService.findByOrder(order);
        assertTrue(offers.size()==3);
        Offer firstOffer = offers.get(0);
        assertTrue(firstOffer.getExpert().getFirstname().equals("aliakbar"));
        assertTrue(firstOffer.getExpert().getScore()==4);
    }
}
