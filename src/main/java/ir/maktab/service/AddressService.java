package ir.maktab.service;

import ir.maktab.dto.AddressDto;


public interface AddressService {

    public AddressDto save(AddressDto addressDto);

    public AddressDto findByZipCode(Long zipCode);
}
