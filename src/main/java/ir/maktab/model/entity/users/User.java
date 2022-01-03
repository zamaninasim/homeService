package ir.maktab.model.entity.users;

import ir.maktab.model.enumeration.UserStatus;

import java.util.Date;

public class User {
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
}
