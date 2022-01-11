package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.services.MainService;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class CustomerServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CustomerService customerService = context.getBean(CustomerService.class);
    Customer customer;

    @Before
    public void init() {
        customer = Customer.builder()
                .firstname("maryam")
                .lastname("goli")
                .emailAddress("maryamgoli213@gmail.com")
                .password("Maryam1245")
                .role(Role.CUSTOMER)
                .userStatus(UserStatus.NEW)
                .credit(0L)
                .build();
    }

    @Test
    public void givenNewCustomer_WhenSave_ThenReturnCustomer() {
        Customer savedCustomer = customerService.save(customer);
        assertEquals(customer, savedCustomer);
    }

    @Test
    public void givenDuplicateCustomer_WhenSave_ThenThrowException() {
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> customerService.save(customer));
        assertTrue(thrown.getMessage().contains("this emailAddress exist!"));
    }

    @Test
    public void givenExistCustomerEmail_WhenFindByEmailAddress_ThenReturnCustomer() {
        Customer customer = customerService.findByEmailAddress("maryamgoli213@gmail.com");
        assertNotNull(customer);
    }

    @Test
    public void givenNotExistCustomerEmail_WhenFindByEmailAddress_ThenThrowException() {
        EntityNotExistException thrown =
                assertThrows(EntityNotExistException.class, () -> customerService.findByEmailAddress("test@gmail.com"));
        assertTrue(thrown.getMessage().contains("emailAddress not exist!"));
    }
}
