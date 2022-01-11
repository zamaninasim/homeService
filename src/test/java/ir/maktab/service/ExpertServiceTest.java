package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import ir.maktab.service.reader.ImageReader;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;

public class ExpertServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    ExpertService expertService = context.getBean(ExpertService.class);
    ImageReader imageReader = context.getBean(ImageReader.class);
    Expert expert;

    @Before
    public void init() {
        byte[] image = new byte[0];
        try {
            image = imageReader.fileToBytes("\\nasim.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        expert = Expert.builder()
                .firstname("aliakbar")
                .lastname("godarzi")
                .emailAddress("aliakbargodarzi@gmail.com")
                .password("akBar1234")
                .credit(0L)
                .userStatus(UserStatus.NEW)
                .score(5.0)
                .photo(image)
                .role(Role.EXPERT)
                .build();
    }

    @Test
    public void givenNewExpert_WhenSave_ThenReturnExpert() {
        Expert savedExpert = expertService.save(expert);
        assertEquals(expert, savedExpert);
    }

    @Test
    public void givenDuplicateExpert_WhenSave_ThenThrowException() {
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> expertService.save(expert));
        assertTrue(thrown.getMessage().contains("this emailAddress exist!"));
    }

    @Test
    public void givenExistCustomerEmail_WhenFindByEmailAddress_ThenReturnMainService() {
        Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
        assertNotNull(expert);
    }

    @Test
    public void givenNotExistCustomerEmail_WhenFindByEmailAddress_ThenThrowException() {
        EntityNotExistException thrown =
                assertThrows(EntityNotExistException.class, () -> expertService.findByEmailAddress("test@gmail.com"));
        assertTrue(thrown.getMessage().contains("emailAddress not exist!"));
    }
}
