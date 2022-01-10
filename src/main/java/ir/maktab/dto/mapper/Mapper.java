package ir.maktab.dto.mapper;

import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.dto.UserDto;
import ir.maktab.data.model.entity.services.SubService;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.entity.users.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public UserDto userDto(User user) {
        return UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .emailAddress(user.getEmailAddress())
                .userStatus(user.getUserStatus())
                .registrationDate(user.getRegistrationDate())
                .credit(user.getCredit())
                .role(user.getRole())
                .build();
    }

    public ExpertDto expertDto(Expert expert) {
        return ExpertDto.builder()
                .firstname(expert.getFirstname())
                .lastname(expert.getLastname())
                .emailAddress(expert.getEmailAddress())
                .userStatus(expert.getUserStatus())
                .registrationDate(expert.getRegistrationDate())
                .credit(expert.getCredit())
                .role(expert.getRole())
                .photo(expert.getPhoto())
                .score(expert.getScore())
                .build();
    }

    public SubServiceDto subServiceDto(SubService subService){
        return SubServiceDto.builder()
                .name(subService.getName())
                .basePrice(subService.getBasePrice())
                .description(subService.getDescription())
                .mainService(subService.getMainService())
                .build();
    }
}
