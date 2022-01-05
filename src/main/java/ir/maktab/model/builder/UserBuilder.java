package ir.maktab.model.builder;

import ir.maktab.model.entity.users.User;
import ir.maktab.model.enumeration.Role;
import ir.maktab.model.enumeration.UserStatus;

import java.util.Date;

public final class UserBuilder {
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
    private Role role;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
        return new UserBuilder();
    }

    public UserBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public UserBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public UserBuilder withCredit(Long credit) {
        this.credit = credit;
        return this;
    }

    public UserBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);
        user.setUserStatus(userStatus);
        user.setRegistrationDate(registrationDate);
        user.setCredit(credit);
        user.setRole(role);
        return user;
    }
}
