package ir.maktab.model.builder;

import ir.maktab.model.entity.Instruction;
import ir.maktab.model.entity.Offer;
import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Customer;
import ir.maktab.model.enumeration.OrderStatus;

import java.util.Date;
import java.util.Set;

public final class InstructionBuilder {
    private Integer id;
    private SubService subService;
    private Long proposedPrice;
    private String jobDescription;
    private Date orderRegistrationDate;
    private Date dateOfWorkPerformed;
    private String address;
    private Customer customer;
    private OrderStatus orderStatus;
    private Set<Offer> suggestions;

    private InstructionBuilder() {
    }

    public static InstructionBuilder anInstruction() {
        return new InstructionBuilder();
    }

    public InstructionBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public InstructionBuilder withSubService(SubService subService) {
        this.subService = subService;
        return this;
    }

    public InstructionBuilder withProposedPrice(Long proposedPrice) {
        this.proposedPrice = proposedPrice;
        return this;
    }

    public InstructionBuilder withJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
        return this;
    }

    public InstructionBuilder withOrderRegistrationDate(Date orderRegistrationDate) {
        this.orderRegistrationDate = orderRegistrationDate;
        return this;
    }

    public InstructionBuilder withDateOfWorkPerformed(Date dateOfWorkPerformed) {
        this.dateOfWorkPerformed = dateOfWorkPerformed;
        return this;
    }

    public InstructionBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public InstructionBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public InstructionBuilder withOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public InstructionBuilder withSuggestions(Set<Offer> suggestions) {
        this.suggestions = suggestions;
        return this;
    }

    public Instruction build() {
        Instruction instruction = new Instruction();
        instruction.setId(id);
        instruction.setSubService(subService);
        instruction.setProposedPrice(proposedPrice);
        instruction.setJobDescription(jobDescription);
        instruction.setOrderRegistrationDate(orderRegistrationDate);
        instruction.setDateOfWorkPerformed(dateOfWorkPerformed);
        instruction.setAddress(address);
        instruction.setCustomer(customer);
        instruction.setOrderStatus(orderStatus);
        instruction.setSuggestions(suggestions);
        return instruction;
    }
}
