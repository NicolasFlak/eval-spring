package hb.spring.evaluation.services;

import hb.spring.evaluation.dtos.UserDTO;
import hb.spring.evaluation.dtos.UserFormDTO;
import hb.spring.evaluation.models.LocalUser;
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

    private PasswordEncoder passwordEncoder;

    private ValidatorFactory validatorFactory;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository userRepository, ValidatorFactory validatorFactory) {

        this.userRepository = userRepository;
        this.validatorFactory = validatorFactory;
    }

    public List<UserDTO> getUsers() {
        List<LocalUser> localUsers = userRepository.getUsers();
        List<UserDTO> localUsersDTOs = new ArrayList<>();

        localUsers.forEach((localUser -> {
            localUsersDTOs.add(new UserDTO(localUser.getId(), localUser.getUsername(), localUser.getRole()));
        }));
        return localUsersDTOs;
    }


    //    On passe d'un UserDTO à un LocalUser :
    public void saveUser(UserFormDTO userFormDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userFormDTO.password());

        LocalUser localUser = new LocalUser();

        localUser.setUsername(userFormDTO.username());
<<<<<<< HEAD
        localUser.setPassword(userFormDTO.password());
=======
        localUser.setPassword(encodedPassword);
>>>>>>> 3c2f3378f38cf7f356e6ae558e47057a73f30759
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
}
