package hb.spring.evaluation.controllers;

import hb.spring.evaluation.configuration.SecurityConfig;
import hb.spring.evaluation.dtos.UserDTO;
import hb.spring.evaluation.models.Category;
import hb.spring.evaluation.services.ProfileService;
import hb.spring.evaluation.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {

    private ProfileService profileService;

    private UserService userService;

    private ProfileController(ProfileService profileService, UserService userService) {
        this.profileService = profileService;
        this.userService = userService;
    }


    @GetMapping("/private/category")
    public ModelAndView getCategoryByUser() {
        UserDTO userDTO = userService.getUserByUsername(SecurityConfig.getUserName());
        ModelAndView mav = new ModelAndView("categories");
        List<Category> categories = profileService.getCategoryByIdUser(userDTO.id());
        mav.addObject("categories", categories);

        return mav;
    }
}
