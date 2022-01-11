package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.users.User;
import ir.maktab.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .identificationNumber(1000L + (user.getId()))
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .emailAddress(user.getEmailAddress())
                .userStatus(user.getUserStatus())
                .registrationDate(user.getRegistrationDate())
                .credit(user.getCredit())
                .role(user.getRole())
                .build();
    }

    public User userDtoToUser(UserDto userDto) {
        return User.builder()
                .id((int) ((userDto.getIdentificationNumber()) - 1000L))
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .emailAddress(userDto.getEmailAddress())
                .userStatus(userDto.getUserStatus())
                .registrationDate(userDto.getRegistrationDate())
                .credit(userDto.getCredit())
                .role(userDto.getRole())
                .build();
    }
}
