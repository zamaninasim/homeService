package ir.maktab.dto;

import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ir.maktab.service.validation.OnLogin;
import ir.maktab.service.validation.OnRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Pattern(regexp = "[a-zA-Z]{3,30}",message = "invalid firstname.", groups = {OnRegister.class})
    private String firstname;
    @Pattern(regexp = "[a-zA-Z]{3,30}",message = "invalid lastname.", groups = {OnRegister.class})
    private String lastname;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email", groups = {OnLogin.class, OnRegister.class})
    private String emailAddress;
    @Pattern(regexp ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",message = "Invalid password", groups = {OnLogin.class, OnRegister.class})
    private String password;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
    private Role role;
}
