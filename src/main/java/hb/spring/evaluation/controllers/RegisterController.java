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
@RequestMapping(value = "/register")
public class RegisterController {
    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView getRegistrationForm() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new UserFormDTO("", ""));
        System.out.println("get mav : " + mav);
        return mav;
    }

    @PostMapping("")
    public ModelAndView registrationUser(@ModelAttribute UserFormDTO user) {
        System.out.println("dans le post, user : " + user);
        userService.saveUser(user);
        ModelAndView mav = new ModelAndView("redirect:/login");
        System.out.println("dans post , mav : " + mav);
        return mav;
    }

}
