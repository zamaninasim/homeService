package ir.maktab.service;

import ir.maktab.data.dao.CustomerRepository;
import ir.maktab.data.model.entity.Offer;
import ir.maktab.data.model.entity.Order;
import ir.maktab.data.model.entity.users.Customer;
import ir.maktab.data.model.entity.users.Expert;
import ir.maktab.data.model.enumeration.OfferStatus;
import ir.maktab.data.model.enumeration.OrderStatus;
import ir.maktab.exception.EntityIsExistException;
import ir.maktab.exception.EntityNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private final OfferService offerService;

    public Customer save(Customer customer) {
        Optional<Customer> foundedCustomer = customerRepository.findByEmailAddress(customer.getEmailAddress());
        if (foundedCustomer.isPresent()) {
            throw new EntityIsExistException("this emailAddress exist!");
        } else {
            return customerRepository.save(customer);
        }
    }

    public Customer findByEmailAddress(String emailAddress) {
        Optional<Customer> customer = customerRepository.findByEmailAddress(emailAddress);
        return customer.orElseThrow(() -> new EntityNotExistException("emailAddress not exist!"));
    }

    public void acceptOfferForOrder(Order order, Expert expert) {
        order.setExpert(expert);
        order.setOrderStatus(OrderStatus.WAITING_FOR_THE_EXPERT_TO_ARRIVE);
        orderService.save(order);
        Offer acceptedOffer = offerService.findByOrderAndExpert(order, expert);
        Set<Offer> offers = order.getOffers();
        for (Offer offer : offers) {
            if (offer.equals(acceptedOffer)) {
                offer.setOfferStatus(OfferStatus.ACCEPTED);
            } else {
                offer.setOfferStatus(OfferStatus.REJECTED);
            }
            offerService.save(offer);
        }
    }
}
