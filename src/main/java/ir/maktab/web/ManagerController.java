package ir.maktab.web;

import ir.maktab.configuration.LastViewInterceptor;
import ir.maktab.dto.MainServiceDto;
import ir.maktab.dto.ManagerDto;
import ir.maktab.dto.SubServiceDto;
import ir.maktab.service.MainServiceService;
import ir.maktab.service.ManagerService;
import ir.maktab.service.SubServiceService;
import ir.maktab.service.exception.ManagerNotFoundException;
import ir.maktab.service.validation.OnLogin;
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
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes({"managerDto"})
@RequiredArgsConstructor
public class ManagerController {
    private final ManagerService managerService;
    private final MainServiceService mainServiceService;
    private final SubServiceService subServiceService;

    @GetMapping("/managerLogin")
    public ModelAndView showLoginPage() {
        return new ModelAndView("manager/login", "managerDto", new ManagerDto());
    }

    @PostMapping("/submitManagerLogin")
    public String loginManagerPage(@ModelAttribute("managerDto") @Validated(OnLogin.class) ManagerDto managerDto, Model model) {
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
        model.put("managerDto", new ManagerDto());
        model.put("error", ex.getMessage());
        return new ModelAndView("manager/login", model);
    }

    @GetMapping("/saveMainService")
    public ModelAndView showAddMainServicePage() {
        return new ModelAndView("manager/saveMainService", "mainServiceDto", new MainServiceDto());
    }

    @PostMapping("/submitSaveMainService")
    public String submitSaveMainServicePage(@ModelAttribute("mainServiceDto")
                                            @Validated(OnRegister.class) MainServiceDto mainServiceDto) {
        mainServiceService.save(mainServiceDto);
        return "redirect:/viewMainService";
    }

    @GetMapping("/viewMainService")
    public String viewMainService(Model model) {
        List<MainServiceDto> list = mainServiceService.findAll();
        model.addAttribute("list", list);
        return "manager/viewMainService";
    }

    @GetMapping("/addSubService/{name}")
    public String showAddSubServicePage(@PathVariable String name, Model model,HttpServletRequest httpServletRequest) {
        model.addAttribute("subServiceDto", new SubServiceDto());
        httpServletRequest.getSession().setAttribute("mainServiceName",name);
        return "manager/saveSubService";
    }

    @PostMapping("addSubService/submitSaveSubService")
    public String submitSaveSubServicePage(@ModelAttribute("subServiceDto") SubServiceDto subServiceDto,HttpServletRequest httpServletRequest) {
        String name = (String) httpServletRequest.getSession().getAttribute("mainServiceName");
        subServiceDto.setMainServiceName(name);
        subServiceService.save(subServiceDto);
        return "redirect:/viewMainService";
    }
}
