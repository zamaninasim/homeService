package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Customer;

import java.util.Date;

public class Order {
    private Integer id;
    private Long proposedPrice;
    private String jobDescription;
    private Date orderRegistrationDate;
    private Date dateOfWorkPerformed;
    private String address;
    private Customer customer;
}
