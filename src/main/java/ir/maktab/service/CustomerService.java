package ir.maktab.service;

import ir.maktab.dao.CustomerDao;
import ir.maktab.validation.exception.ExistException;
import ir.maktab.model.entity.users.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    public Customer findByEmailAddress(String emailAddress) {
        Optional<Customer> customer = customerDao.findByEmailAddress(emailAddress);
        if (customer.isPresent()) {
            Customer foundedCustomer = customer.get();
            return foundedCustomer;
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }
    }

    public boolean isExist(String emailAddress) {
        Optional<Customer> customer = customerDao.findByEmailAddress(emailAddress);
        if (customer.isPresent()) {
            throw new ExistException("this emailAddress exist!");
        } else {
            return false;
        }
    }
}
