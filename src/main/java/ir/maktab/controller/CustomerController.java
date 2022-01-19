package ir.maktab.controller;

import ir.maktab.dto.CustomerDto;
import ir.maktab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @RequestMapping(value = "/customerLogin", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "customerLogin";
    }

    @RequestMapping(value = "/submitCustomerLogin", method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("customerDto") CustomerDto customerDto) {
        if (customerDto != null && customerDto.getEmailAddress() != null & customerDto.getPassword() != null) {
            try {
                CustomerDto founded = customerService.findByEmailAddress(customerDto.getEmailAddress());
                if (customerDto.getEmailAddress().equals(founded.getEmailAddress()) && customerDto.getPassword().equals(founded.getPassword())) {
                    model.addAttribute("firstname", founded.getFirstname());
                    model.addAttribute("lastname", founded.getLastname());
                    return "customerProfile";
                } else {
                    model.addAttribute("error", "Invalid Email or Password");
                    return "customerLogin";
                }
            } catch (RuntimeException e) {
                model.addAttribute("error", "Invalid Email or Password");
                return "customerLogin";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "customerLogin";
        }
    }
}