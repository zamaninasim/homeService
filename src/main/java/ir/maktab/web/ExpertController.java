package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.data.model.enumeration.Role;
import ir.maktab.data.model.enumeration.UserStatus;
import ir.maktab.dto.CustomerDto;
import ir.maktab.dto.ExpertDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.exception.CustomerIsExistException;
import ir.maktab.service.exception.CustomerNotFoundException;
import ir.maktab.service.exception.ExpertIsExistException;
import ir.maktab.service.exception.ExpertNotFoundException;
import ir.maktab.service.validation.OnLogin;
import ir.maktab.service.validation.OnRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ExpertController {
    private final ExpertService expertService;

    @RequestMapping(value = "/expertHome", method = RequestMethod.GET)
    public String getExpertHomeView(Model model) {
        model.addAttribute("expertDto", new ExpertDto());
        return "expert/register";
    }

    @PostMapping("/expertRegister")
    public String registerExpert(@ModelAttribute("expertDto") @Validated(OnRegister.class) ExpertDto expertDto,
                                 @RequestParam("image") CommonsMultipartFile image) {
        expertDto.setPhoto(image.getBytes());
        expertDto.setScore(5.0);
        expertDto.setUserStatus(UserStatus.NEW);
        expertDto.setCredit(0L);
        expertDto.setRole(Role.EXPERT);
        expertService.save(expertDto);
        return "expert/profile";
    }

    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex, HttpServletRequest request) {
        String lastView = (String) request.getSession().getAttribute(LastViewInterceptor.LAST_VIEW_ATTRIBUTE);
        return new ModelAndView(lastView, ex.getBindingResult().getModel());
    }

    @ExceptionHandler(value = ExpertIsExistException.class)
    public ModelAndView registerExceptionHandler(ExpertIsExistException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("expertDto", new CustomerDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("expert/register", model);
    }

    @GetMapping("/expertLogin")
    public ModelAndView showLoginPage() {
        return new ModelAndView("expert/login", "expertDto", new ExpertDto());
    }

    @PostMapping("/submitExpertLogin")
    public String loginCustomer(@ModelAttribute("expertDto") @Validated(OnLogin.class) ExpertDto expertDto, Model model) {
        ExpertDto found = expertService.findByEmailAddressAndPassword(expertDto.getEmailAddress(), expertDto.getPassword());
        model.addAttribute("expertDto",found);
        return "expert/profile";
    }

    @ExceptionHandler(value = ExpertNotFoundException.class)
    public ModelAndView LoginExceptionHandler(ExpertNotFoundException ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("expertDto", new ExpertDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("expert/login", model);
    }
}
