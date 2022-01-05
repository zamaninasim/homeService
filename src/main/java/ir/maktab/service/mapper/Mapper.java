package ir.maktab.service.mapper;

import ir.maktab.model.builder.ExpertDtoBuilder;
import ir.maktab.model.builder.SubServiceDtoBuilder;
import ir.maktab.model.builder.UserDtoBuilder;
import ir.maktab.model.dto.ExpertDto;
import ir.maktab.model.dto.SubServiceDto;
import ir.maktab.model.dto.UserDto;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Expert;
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

    public ExpertDto expertDto(Expert expert) {
        return ExpertDtoBuilder.anExpertDto()
                .withFirstname(expert.getFirstname())
                .withLastname(expert.getLastname())
                .withEmailAddress(expert.getEmailAddress())
                .withUserStatus(expert.getUserStatus())
                .withRegistrationDate(expert.getRegistrationDate())
                .withCredit(expert.getCredit())
                .withRole(expert.getRole())
                .withPhoto(expert.getPhoto())
                .withScore(expert.getScore())
                .build();
    }

    public SubServiceDto subServiceDto(SubService subService){
        return SubServiceDtoBuilder.aSubServiceDto()
                .withName(subService.getName())
                .withBasePrice(subService.getBasePrice())
                .withDescription(subService.getDescription())
                .withMainService(subService.getMainService())
                .build();
    }
}
