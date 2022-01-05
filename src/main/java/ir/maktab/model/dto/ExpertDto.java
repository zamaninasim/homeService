package ir.maktab.model.dto;

import ir.maktab.model.enumeration.Role;
import ir.maktab.model.enumeration.UserStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ExpertDto {
    private String firstname;
    private String lastname;
    private String emailAddress;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
    private Role role;
    private byte[] photo;
    private Double score;
}
