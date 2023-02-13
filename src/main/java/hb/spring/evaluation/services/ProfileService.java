package hb.spring.evaluation.services;

import hb.spring.evaluation.models.Category;
import hb.spring.evaluation.models.LocalUser;
import hb.spring.evaluation.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public List<Category> getCategoryByUser(LocalUser localUser) {
        List<Category> categories = new ArrayList<>();
        for(String categoryName : localUser.getCategories()) {
            categories.add(this.profileRepository.getCategoryByName(categoryName));
        }
        return categories;
    }


}
