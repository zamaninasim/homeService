package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.Order;
import ir.maktab.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final AddressMapper addressMapper;
    private final CustomerMapper customerMapper;
    private final ExpertMapper expertMapper;
    private final SubServiceMapper subServiceMapper;

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
