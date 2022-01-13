package ir.maktab.service;

import ir.maktab.config.Config;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.entity.users.User;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import ir.maktab.exception.InCorrectException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    UserService userService = context.getBean(UserService.class);
    User user;

    @Before
    public void init() {
        user = Customer.builder()
                .firstname("neda")
                .lastname("akbari")
                .emailAddress("nedaakbari213@gmail.com")
                .password("nedA1377")
                .role(Role.CUSTOMER)
                .userStatus(UserStatus.NEW)
                .credit(0L)
                .build();
    }

    @Test
    public void givenNewUser_WhenSave_ThenReturnUser() {
        User savedUser = userService.save(user);
        assertEquals(user, savedUser);
    }

    @Test
    public void givenDuplicateUser_WhenSave_ThenThrowException() {
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> userService.save(user));
        assertTrue(thrown.getMessage().contains("this emailAddress exist!"));
    }

    @Test
    public void givenExistUserEmail_WhenFindByEmailAddress_ThenReturnUser() {
        User user = userService.findByEmailAddress("nedaakbari213@gmail.com");
        assertNotNull(user);
    }

    @Test
    public void givenNotExistUserEmail_WhenFindByEmailAddress_ThenThrowException() {
        EntityNotExistException thrown =
                assertThrows(EntityNotExistException.class, () -> userService.findByEmailAddress("test@gmail.com"));
        assertTrue(thrown.getMessage().contains("emailAddress not exist!"));
    }

    @Test
    public void givenUserAndCurrentPass_WhenChangePassword_returnUpdatedUser() {
        User user = userService.findByEmailAddress("aliakbargodarzi@gmail.com");
        User updatedUser = userService.changePassword(user, "akBar1234", "aliA1234");
        assertEquals(updatedUser.getPassword(), "aliA1234");
    }

    @Test
    public void givenUserAndWrongCurrentPass_WhenChangePassword_ThenThrowException() {
        User user = userService.findByEmailAddress("aliakbargodarzi@gmail.com");
        InCorrectException thrown =
                assertThrows(InCorrectException.class, () -> userService.changePassword(user, "aliA1234", "akBar1234"));
        assertTrue(thrown.getMessage().contains("password is wrong!"));
    }

    @Test
    public void givenAllCondition_WhenFindUserByCondition_ThenReturnUserList() {
        List<User> usersByCondition = userService.findUserByCondition(this.user.getFirstname(), this.user.getLastname(), this.user.getEmailAddress(), this.user.getRole());
        assertEquals(1, usersByCondition.size());
        assertEquals(usersByCondition.get(0).getEmailAddress(), user.getEmailAddress());
    }

    @Test
    public void givenSomeCondition_WhenFindUserByCondition_ThenReturnUserList() {
        List<User> usersByCondition = userService.findUserByCondition(this.user.getFirstname(), null, this.user.getEmailAddress(), null);
        assertEquals(1, usersByCondition.size());
        assertEquals(usersByCondition.get(0).getEmailAddress(), user.getEmailAddress());
    }
}
