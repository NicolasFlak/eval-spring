package hb.spring.evaluation.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import hb.spring.evaluation.models.Post;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class PostRepository {

    private final static Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            File resourceJson = new ClassPathResource("posts.json").getFile();
            posts = mapper.readValue(
                    resourceJson,
                    new TypeReference<List<Post>>() {} );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public void save(Post newPost) {
        List<Post> existingPosts = getPosts();
        int newId = 0;
        for (Post existingPost : existingPosts) {
            if (existingPost.getId() >= newId) {
                newId = existingPost.getId() + 1;
            }
        }
        newPost.setId(newId);
        existingPosts.add(newPost);

        ObjectMapper mapper = new ObjectMapper();
        try {
            File resourceJson = new File("src/main/resources/posts.json");
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(existingPosts);

            logger.info(jsonString);

            BufferedWriter writer = new BufferedWriter(new FileWriter(resourceJson));
            writer.write(jsonString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}