package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.dto.CustomerDto;
import ir.maktab.service.CustomerService;
import ir.maktab.service.exception.CustomerIsExistException;
import ir.maktab.service.validation.OnRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = CustomerIsExistException.class)
    public ModelAndView registerExceptionHandler(CustomerIsExistException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("customerDto", new CustomerDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("customer/register", model);
    }
}