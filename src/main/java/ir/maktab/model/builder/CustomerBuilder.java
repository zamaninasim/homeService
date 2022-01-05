package ir.maktab.model.builder;

import ir.maktab.model.entity.users.Customer;
import ir.maktab.model.enumeration.Role;
import ir.maktab.model.enumeration.UserStatus;

import java.util.Date;

public final class CustomerBuilder {
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
    private Role role;

    private CustomerBuilder() {
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public CustomerBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CustomerBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CustomerBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public CustomerBuilder withUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public CustomerBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public CustomerBuilder withCredit(Long credit) {
        this.credit = credit;
        return this;
    }

    public CustomerBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public Customer build() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmailAddress(emailAddress);
        customer.setPassword(password);
        customer.setUserStatus(userStatus);
        customer.setRegistrationDate(registrationDate);
        customer.setCredit(credit);
        customer.setRole(role);
        return customer;
    }
}
