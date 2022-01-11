package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.Order;
import ir.maktab.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private AddressMapper addressMapper;
    private CustomerMapper customerMapper;
    private ExpertMapper expertMapper;
    private SubServiceMapper subServiceMapper;

    @Autowired
    public OrderMapper(AddressMapper addressMapper, CustomerMapper customerMapper, ExpertMapper expertMapper, SubServiceMapper subServiceMapper) {
        this.addressMapper = addressMapper;
        this.customerMapper = customerMapper;
        this.expertMapper = expertMapper;
        this.subServiceMapper = subServiceMapper;
    }

    public OrderDto orderToOrderDto(Order order) {
        return OrderDto.builder()
                .identificationNumber((order.getId()) + 1000L)
                .subServiceDto(subServiceMapper.subServiceToSubServiceDto(order.getSubService()))
                .proposedPrice(order.getProposedPrice())
                .jobDescription(order.getJobDescription())
                .dateOfWorkPerformed(order.getDateOfWorkPerformed())
                .addressDto(addressMapper.addressToAddressDto(order.getAddress()))
                .customerDto(customerMapper.customerToCustomerDto(order.getCustomer()))
                .orderStatus(order.getOrderStatus())
                .expertDto(expertMapper.expertToExpertDto(order.getExpert()))
                .build();
    }

    public Order orderDtoToOrder(OrderDto orderDto) {
        return Order.builder()
                .id((int) ((orderDto.getIdentificationNumber()) - 1000))
                .subService(subServiceMapper.subServiceDtoToSubService(orderDto.getSubServiceDto()))
                .proposedPrice(orderDto.getProposedPrice())
                .jobDescription(orderDto.getJobDescription())
                .dateOfWorkPerformed(orderDto.getDateOfWorkPerformed())
                .address(addressMapper.addressDtoToAddress(orderDto.getAddressDto()))
                .customer(customerMapper.customerDtoToCustomer(orderDto.getCustomerDto()))
                .orderStatus(orderDto.getOrderStatus())
                .expert(expertMapper.expertDtoToExpert(orderDto.getExpertDto()))
                .build();
    }
}
