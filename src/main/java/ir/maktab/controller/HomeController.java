package ir.maktab.controller;

import ir.maktab.dto.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String getHomeView(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/register";
    }
}
