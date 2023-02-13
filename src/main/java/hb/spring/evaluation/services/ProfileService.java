package hb.spring.evaluation.services;

import hb.spring.evaluation.models.Category;
import hb.spring.evaluation.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    public List<Category> getCategoryByIdUser(Integer idUser) {
        return profileRepository.getCategoriesByIdUser(idUser);
    }

}
