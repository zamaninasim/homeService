package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.ExpertDto;
import ir.maktab.dto.ManagerDto;
import ir.maktab.service.ManagerService;
import ir.maktab.service.exception.ManagerNotFoundException;
import ir.maktab.service.validation.OnLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/managerLogin")
    public ModelAndView showLoginPage() {
        return new ModelAndView("manager/login", "managerDto", new ManagerDto());
    }

    @PostMapping("/submitManagerLogin")
    public String loginManager(@ModelAttribute("managerDto") @Validated(OnLogin.class) ManagerDto managerDto, Model model) {
        ManagerDto found = managerService.findByEmailAddressAndPassword(managerDto.getEmailAddress(), managerDto.getPassword());
        model.addAttribute("managerDto", found);
        return "manager/profile";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = ManagerNotFoundException.class)
    public ModelAndView LoginExceptionHandler(ManagerNotFoundException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("managerDto", new ExpertDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("manager/login", model);
    }
}
