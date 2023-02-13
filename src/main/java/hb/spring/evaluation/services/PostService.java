package hb.spring.evaluation.services;

import hb.spring.evaluation.configuration.SecurityConfig;
import hb.spring.evaluation.dtos.PostDTO;
import hb.spring.evaluation.models.Post;
import hb.spring.evaluation.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostDTO> getPosts() {
        List<Post> posts = postRepository.getPosts();
        List<PostDTO> postsDtos = new ArrayList<>();

        posts.forEach((post) -> {
            postsDtos.add(new PostDTO(post.getId(), post.getTitle(), post.getContent()));
        });

        return postsDtos;
    }

    public void saveNewPost(PostDTO newPostDTO) {
        Post newPost = new Post();
        newPost.setTitle(newPostDTO.title());
        newPost.setContent(newPostDTO.content());
        newPost.setCreatorName(SecurityConfig.getUserName());
        newPost.setCreationDate(new Date());

        postRepository.save(newPost);
    }
}