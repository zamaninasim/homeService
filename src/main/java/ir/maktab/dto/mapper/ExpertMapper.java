package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.dto.ExpertDto;
import org.springframework.stereotype.Component;

@Component
public class ExpertMapper {
    public ExpertDto expertToExpertDto(Expert expert) {
        return ExpertDto.builder()
                .identificationNumber(1000L+(expert.getId()))
                .firstname(expert.getFirstname())
                .lastname(expert.getLastname())
                .emailAddress(expert.getEmailAddress())
                .userStatus(expert.getUserStatus())
                .registrationDate(expert.getRegistrationDate())
                .role(expert.getRole())
                .photo(expert.getPhoto())
                .score(expert.getScore())
                .build();
    }
    public Expert expertDtoToExpert(ExpertDto expertDto) {
        return Expert.builder()
                .id((int) ((expertDto.getIdentificationNumber())-1000))
                .firstname(expertDto.getFirstname())
                .lastname(expertDto.getLastname())
                .emailAddress(expertDto.getEmailAddress())
                .userStatus(expertDto.getUserStatus())
                .registrationDate(expertDto.getRegistrationDate())
                .role(expertDto.getRole())
                .photo(expertDto.getPhoto())
                .score(expertDto.getScore())
                .build();
    }
}
