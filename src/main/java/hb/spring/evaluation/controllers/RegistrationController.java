package hb.spring.evaluation.controllers;



import hb.spring.evaluation.dtos.UserFormDTO;
import hb.spring.evaluation.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView getRegistrationForm() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("user", new UserFormDTO("", ""));
        return mav;
    }

    @PostMapping("")
    public String registrationUser(@ModelAttribute UserFormDTO user) {
        userService.saveUser(user);
//        ModelAndView mav = new ModelAndView("redirect:/home");
        return "home";
    }

}
