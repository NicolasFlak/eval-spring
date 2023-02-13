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
        System.out.println("get mav : " + mav);
        return mav;
    }

    @PostMapping("")
<<<<<<< HEAD:src/main/java/hb/spring/evaluation/controllers/RegisterController.java
    public ModelAndView registrationUser(@ModelAttribute UserFormDTO user) {
        System.out.println("dans le post, user : " + user);
        userService.saveUser(user);
        ModelAndView mav = new ModelAndView("redirect:/login");
        System.out.println("dans post , mav : " + mav);
        return mav;
=======
    public String registrationUser(@ModelAttribute UserFormDTO user) {
        userService.saveUser(user);
//        ModelAndView mav = new ModelAndView("redirect:/home");
        return "home";
>>>>>>> 3c2f3378f38cf7f356e6ae558e47057a73f30759:src/main/java/hb/spring/evaluation/controllers/RegistrationController.java
    }

}
