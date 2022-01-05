package ir.maktab.service.mapper;

import ir.maktab.model.builder.UserDtoBuilder;
import ir.maktab.model.dto.UserDto;
import ir.maktab.model.entity.users.User;

public class Mapper {
    public UserDto userDto(User user) {
        return UserDtoBuilder.anUserDto()
                .withFirstname(user.getFirstname())
                .withLastname(user.getLastname())
                .withEmailAddress(user.getEmailAddress())
                .withUserStatus(user.getUserStatus())
                .withRegistrationDate(user.getRegistrationDate())
                .withCredit(user.getCredit())
                .withRole(user.getRole())
                .build();
    }
}
