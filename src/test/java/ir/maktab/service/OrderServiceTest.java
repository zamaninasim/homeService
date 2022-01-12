package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.Address;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.enumeration.OrderStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CustomerService customerService = context.getBean(CustomerService.class);
    SubServiceService subServiceService = context.getBean(SubServiceService.class);
    OrderService orderService = context.getBean(OrderService.class);
    AddressService addressService = context.getBean(AddressService.class);
    Order order;

    @Before
    public void init() {
        Customer customer = customerService.findByEmailAddress("maryamgoli213@gmail.com");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 12:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SubService subService = subServiceService.findByName("cleaning");
        Address address = addressService.findByZipCode(86165841L);
        order = Order.builder()
                .proposedPrice(1000000L)
                .jobDescription("description")
                .dateOfWorkPerformed(date)
                .address(address)
                .customer(customer)
                .orderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTIONS)
                .subService(subService)
                .build();
    }

    @Test
    public void givenOrder_WhenSave_ThenReturnOrder() {
        Order savedOrder = orderService.save(order);
        assertEquals(order, savedOrder);
    }
}
