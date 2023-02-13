package hb.spring.evaluation.controllers;

import hb.spring.evaluation.dtos.UserDTO;
import hb.spring.evaluation.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("private/profile")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView adminPage() {
        List<UserDTO> localUsers = userService.getUsers();
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("users", localUsers);
        return mav;
    }

//    @GetMapping("/")
//    public ModelAndView profilePage(Integer id) {
//        UserDTO localUser = userService.getUserById(id);
//        ModelAndView mav = new ModelAndView("profile");
//        mav.addObject("user", localUser);
//        return mav;
//    }

}