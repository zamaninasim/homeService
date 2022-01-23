package ir.maktab.web;

import ir.maktab.dto.ExpertDto;
import ir.maktab.service.ExpertService;
import ir.maktab.service.validation.OnRegister;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
        //service
        expertService.save(expertDto);
        return "expert/profile";
    }
}
