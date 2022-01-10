package ir.maktab.service;

import ir.maktab.data.dao.CustomerRepository;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void save(Customer customer) {
        Optional<Customer> foundedCustomer = customerRepository.findByEmailAddress(customer.getEmailAddress());
        if (foundedCustomer.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            customerRepository.save(customer);
        }
    }

    public Customer findByEmailAddress(String emailAddress) {
        Optional<Customer> customer = customerRepository.findByEmailAddress(emailAddress);
        return customer.orElseThrow(()->new EntityNotExistException("emailAddress not exist!"));
        /*if (customer.isPresent()) {
            Customer foundedCustomer = customer.get();
            return foundedCustomer;
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }*/
    }

    public boolean isExist(String emailAddress) {
        Optional<Customer> customer = customerRepository.findByEmailAddress(emailAddress);
        if (customer.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            return false;
        }
    }
}
