package hb.spring.evaluation.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hb.spring.evaluation.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfileRepository {

    private final static Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public List<Category> getCategories() {
        List<Category> allCategories = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try {
            File resourceJson = new ClassPathResource("categories.json").getFile();
            allCategories = mapper.readValue(
                    resourceJson,
                    new TypeReference<List<Category>>() {} );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allCategories;
    }

    public Category getCategoryByName(String name) {
        List<Category> categories = getCategories();

        for(Category category : categories) {
            if(category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }



//    public List<Category> getCategoriesByIdUser(Integer idUser) {
//        List<Category> allCategories = new ArrayList<>();
//        List<Category> categories = new ArrayList<>();
//
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            File resourceJson = new ClassPathResource("categories.json").getFile();
//            allCategories = mapper.readValue(
//                    resourceJson,
//                    new TypeReference<List<Category>>() {} );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for(Category category : allCategories) {
//            if(category.getIdUser()!=null) {
//                if(category.getIdUser().equals(idUser)) {
//                    categories.add(category);
//                }}
//        }
//
//        return categories;
//    }


}
