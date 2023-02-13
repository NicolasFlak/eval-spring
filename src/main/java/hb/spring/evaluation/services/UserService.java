package hb.spring.evaluation.services;

import hb.spring.evaluation.dtos.UserDTO;
import hb.spring.evaluation.dtos.UserFormDTO;
import hb.spring.evaluation.models.Category;
import hb.spring.evaluation.models.LocalUser;
import hb.spring.evaluation.repositories.ProfileRepository;
import hb.spring.evaluation.repositories.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private ProfileService profileService;

    private PasswordEncoder passwordEncoder;

    private ValidatorFactory validatorFactory;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository userRepository, ValidatorFactory validatorFactory, ProfileService profileService) {

        this.userRepository = userRepository;
        this.validatorFactory = validatorFactory;
        this.profileService = profileService;
    }



//    public UserDTO getUserById(Integer id) {
//        LocalUser localUser = userRepository.getUserById(id);
//        return null;
//    }


    public void saveUser(UserFormDTO userFormDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userFormDTO.password());

        LocalUser localUser = new LocalUser();

        localUser.setUsername(userFormDTO.username());

        localUser.setPassword(encodedPassword);

        localUser.setRole("USER");

        Set<ConstraintViolation<LocalUser>> violations = validatorFactory.getValidator().validate(localUser);
        if(violations.isEmpty()) {
            userRepository.save(localUser);
        } else {
            // ....
            logger.error("Validation failed !");
            violations.forEach((violation) -> { logger.error(violation.getMessage()); });
        }
    }

    public List<UserDTO> getUsers() {
        List<LocalUser> localUsers = userRepository.getUsers();
        List<UserDTO> localUsersDTOs = new ArrayList<>();

        localUsers.forEach((localUser -> {

            localUsersDTOs.add(new UserDTO(localUser.getId(), localUser.getUsername(), this.profileService.getCategoryByUser(localUser)));
        }));
        return localUsersDTOs;
    }

    public UserDTO getUserByUsername(String username) {
        LocalUser localUser = userRepository.getUserByUsername(username);
        return new UserDTO(localUser.getId(), localUser.getUsername(), this.profileService.getCategoryByUser(localUser));
    }

}
