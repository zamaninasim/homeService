package ir.maktab.service;

import ir.maktab.data.dao.AddressRepository;
import ir.maktab.data.model.entity.Address;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address save(Address address) {
        Optional<Address> foundedAddress = addressRepository.findByZipCode(address.getZipCode());
        return foundedAddress.orElseGet(() -> addressRepository.save(address));
    }

    public Address findByZipCode(Long zipCode) {
        Optional<Address> address = addressRepository.findByZipCode(zipCode);
        return address.orElseThrow(() -> new EntityNotExistException("address not exist!"));
    }
}
