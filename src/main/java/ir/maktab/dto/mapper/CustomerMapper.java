package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.dto.CustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDto customerToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .identificationNumber(1000L + (customer.getId()))
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .emailAddress(customer.getEmailAddress())
                .userStatus(customer.getUserStatus())
                .registrationDate(customer.getRegistrationDate())
                .credit(customer.getCredit())
                .role(customer.getRole())
                .build();
    }

    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .id((int) ((customerDto.getIdentificationNumber()) - 1000L))
                .firstname(customerDto.getFirstname())
                .lastname(customerDto.getLastname())
                .emailAddress(customerDto.getEmailAddress())
                .userStatus(customerDto.getUserStatus())
                .registrationDate(customerDto.getRegistrationDate())
                .credit(customerDto.getCredit())
                .role(customerDto.getRole())
                .build();
    }
}
