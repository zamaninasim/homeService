package ir.maktab.dto;

import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpertDto {
    private Long identificationNumber;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private UserStatus userStatus;
    private Date registrationDate;
    private Role role;
    private byte[] photo;
    private Double score;
}
