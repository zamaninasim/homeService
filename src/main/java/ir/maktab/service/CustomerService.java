package ir.maktab.service;

import ir.maktab.dao.CustomerDao;
import ir.maktab.validation.exception.IsExistException;
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
        Optional<Customer> foundedCustomer = customerDao.findByEmailAddress(customer.getEmailAddress());
        if (foundedCustomer.isPresent()) {
            throw new IsExistException("this emailAddress exist!");
        } else {
            customerDao.save(customer);
            System.out.println("customer whit '" + customer.getEmailAddress() + "' emailAddress saved.");
        }
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
            throw new IsExistException("this emailAddress exist!");
        } else {
            return false;
        }
    }
}
