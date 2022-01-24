package ir.maktab.dto;

import ir.maktab.service.validation.OnLogin;
import ir.maktab.service.validation.OnRegister;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {
    @Pattern(regexp = "[a-zA-Z]{3,30}",message = "invalid firstname.", groups = {OnRegister.class})
    private String firstname;
    @Pattern(regexp = "[a-zA-Z]{3,30}",message = "invalid lastname.", groups = {OnRegister.class})
    private String lastname;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email", groups = {OnLogin.class, OnRegister.class})
    private String emailAddress;
    @Pattern(regexp ="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",message = "Invalid password", groups = {OnLogin.class, OnRegister.class})
    private String password;
}