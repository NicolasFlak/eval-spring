package hb.spring.evaluation.controllers;

import hb.spring.evaluation.dtos.PostDTO;
import hb.spring.evaluation.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.List;

@Controller
@RequestMapping(value = "/private/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public ModelAndView getPosts() {
        List<PostDTO> posts = postService.getPosts();
        ModelAndView mav = new ModelAndView("posts");
        mav.addObject("posts", posts);
        return mav;
    }


//Création de post

    @GetMapping("/newPost")
    public ModelAndView getNewPost() {
        ModelAndView mav = new ModelAndView("newPost");
        mav.addObject("newPost", new PostDTO(0, "", ""));
        return mav;
    }

    @PostMapping("/newPost")
    public String postNewPost(@ModelAttribute PostDTO newPostDTO) {
        postService.saveNewPost(newPostDTO);
        return "home";
    }

}