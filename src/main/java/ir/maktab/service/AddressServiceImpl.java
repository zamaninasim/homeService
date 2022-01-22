package ir.maktab.service;

import ir.maktab.data.dao.AddressRepository;
import ir.maktab.data.model.entity.Address;
import ir.maktab.dto.AddressDto;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        Optional<Address> foundedAddress = addressRepository.findByZipCode(address.getZipCode());
        Address savedAddress = foundedAddress.orElseGet(() -> addressRepository.save(address));
        return modelMapper.map(savedAddress, AddressDto.class);
    }

    @Override
    public AddressDto findByZipCode(Long zipCode) {
        Optional<Address> optionalAddress = addressRepository.findByZipCode(zipCode);
        Address address = optionalAddress.orElseThrow(() -> new EntityNotExistException("address not exist!"));
        return modelMapper.map(address, AddressDto.class);
    }
}
