package ir.maktab.model.builder;

import ir.maktab.model.dto.ExpertDto;
import ir.maktab.model.enumeration.Role;
import ir.maktab.model.enumeration.UserStatus;

import java.util.Date;

public final class ExpertDtoBuilder {
    private String firstname;
    private String lastname;
    private String emailAddress;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;
    private Role role;
    private byte[] photo;
    private Double score;

    private ExpertDtoBuilder() {
    }

    public static ExpertDtoBuilder anExpertDto() {
        return new ExpertDtoBuilder();
    }

    public ExpertDtoBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ExpertDtoBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ExpertDtoBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ExpertDtoBuilder withUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public ExpertDtoBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public ExpertDtoBuilder withCredit(Long credit) {
        this.credit = credit;
        return this;
    }

    public ExpertDtoBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public ExpertDtoBuilder withPhoto(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public ExpertDtoBuilder withScore(Double score) {
        this.score = score;
        return this;
    }

    public ExpertDto build() {
        ExpertDto expertDto = new ExpertDto();
        expertDto.setFirstname(firstname);
        expertDto.setLastname(lastname);
        expertDto.setEmailAddress(emailAddress);
        expertDto.setUserStatus(userStatus);
        expertDto.setRegistrationDate(registrationDate);
        expertDto.setCredit(credit);
        expertDto.setRole(role);
        expertDto.setPhoto(photo);
        expertDto.setScore(score);
        return expertDto;
    }
}
