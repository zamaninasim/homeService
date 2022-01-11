package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.Address;
import ir.maktab.dto.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDto addressToAddressDto(Address address) {
        return AddressDto.builder()
                .city(address.getCity())
                .state(address.getState())
                .streetAddress(address.getStreetAddress())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .build();

    }

    public Address addressDtoToAddress(AddressDto addressDto) {
        return Address.builder()
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .streetAddress(addressDto.getStreetAddress())
                .houseNumber(addressDto.getHouseNumber())
                .zipCode(addressDto.getZipCode())
                .build();

    }
}
