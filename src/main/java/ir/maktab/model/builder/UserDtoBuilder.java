package ir.maktab.model.builder;

import ir.maktab.model.dto.UserDto;
import ir.maktab.model.enumeration.Role;
import ir.maktab.model.enumeration.UserStatus;

import java.util.Date;

public final class UserDtoBuilder {
    private String firstname;
    private String lastname;
    private String emailAddress;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
    private Role role;

    private UserDtoBuilder() {
    }

    public static UserDtoBuilder anUserDto() {
        return new UserDtoBuilder();
    }

    public UserDtoBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public UserDtoBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public UserDtoBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public UserDtoBuilder withUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public UserDtoBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public UserDtoBuilder withCredit(Long credit) {
        this.credit = credit;
        return this;
    }

    public UserDtoBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public UserDto build() {
        UserDto userDto = new UserDto();
        userDto.setFirstname(firstname);
        userDto.setLastname(lastname);
        userDto.setEmailAddress(emailAddress);
        userDto.setUserStatus(userStatus);
        userDto.setRegistrationDate(registrationDate);
        userDto.setCredit(credit);
        userDto.setRole(role);
        return userDto;
    }
}
