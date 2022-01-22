package ir.maktab.service;

import ir.maktab.data.dao.CustomerRepository;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.enumeration.OfferStatus;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.OfferDto;
import ir.maktab.dto.OrderDto;
import ir.maktab.service.exception.EntityIsExistException;
import ir.maktab.service.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderServiceImpl orderService;
    private final OfferServiceImpl offerService;
    private final ModelMapper modelMapper;

    @Override
    public void save(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Optional<Customer> foundedCustomer = customerRepository.findByEmailAddress(customer.getEmailAddress());
        if (foundedCustomer.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            customerRepository.save(customer);
        }
    }

    @Override
    public CustomerDto findByEmailAddress(String emailAddress) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailAddress(emailAddress);
        Customer customer = optionalCustomer.orElseThrow(() -> new EntityNotExistException("emailAddress not exist!"));
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public void acceptOfferForOrder(OrderDto orderDto, ExpertDto expertDto) {
        orderDto.setExpert(expertDto);
        orderDto.setOrderStatus(OrderStatus.WAITING_FOR_THE_EXPERT_TO_ARRIVE);
        orderService.save(orderDto);
        OfferDto acceptedOfferDto = offerService.findByOrderAndExpert(orderDto, expertDto);
        Set<OfferDto> offerDtos = orderDto.getOffers();
        for (OfferDto offerDto : offerDtos) {
            if (offerDto.equals(acceptedOfferDto)) {
                offerDto.setOfferStatus(OfferStatus.ACCEPTED);
            } else {
                offerDto.setOfferStatus(OfferStatus.REJECTED);
            }
            offerService.save(offerDto);
        }
    }
}
