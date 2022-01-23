package ir.maktab.service;

import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OrderDto;

import java.util.Optional;

public interface CustomerService {

    public void save(CustomerDto customerDto);

    public CustomerDto findByEmailAddress(String emailAddress);

    public void acceptOfferForOrder(OrderDto orderDto, ExpertDto expertDto);

    CustomerDto findByEmailAddressAndPassword(String email, String password);
}
