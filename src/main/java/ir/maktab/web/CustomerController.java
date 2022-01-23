package ir.maktab.web;

import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.dto.CustomerDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.validation.OnRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    public final CustomerService customerService;

    @RequestMapping(value = "/customerHome", method = RequestMethod.GET)
    public String getCustomerHomeView(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/register";
    }

    @PostMapping("/customerRegister")
    public String registerCustomer(@ModelAttribute("customerDto") @Validated(OnRegister.class) CustomerDto customerDto) {
        customerDto.setUserStatus(UserStatus.NEW);
        customerDto.setCredit(0L);
        customerDto.setRole(Role.CUSTOMER);
        customerService.save(customerDto);
        return "customer/profile";
    }
}