package ir.maktab.model.entity;

import ir.maktab.model.entity.users.Customer;
import ir.maktab.model.enumeration.OrderStatus;

import java.util.Date;
import java.util.Set;

public class Order {
    private Integer id;
    private Long proposedPrice;
    private String jobDescription;
    private Date orderRegistrationDate;
    private Date dateOfWorkPerformed;
    private String address;
    private Customer customer;
    private OrderStatus orderStatus;
    private Set<Suggestion> suggestions;
}
