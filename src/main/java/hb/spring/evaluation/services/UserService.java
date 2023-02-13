package hb.spring.evaluation.services;

import hb.spring.evaluation.dtos.UserDTO;
import hb.spring.evaluation.dtos.UserFormDTO;
import hb.spring.evaluation.models.LocalUser;
import hb.spring.evaluation.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;


    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDTO> getUsers() {

        List<LocalUser> localUsers = userRepository.getUsers();
        List<UserDTO> userDtos = new ArrayList<>();

        localUsers.forEach((localUser) -> {
            userDtos.add(new UserDTO(localUser.getId(), localUser.getUsername(), localUser.getRole()));
        });

        return userDtos;
    }

    public void saveUser(UserFormDTO userFormDTO) {
        LocalUser localUser = new LocalUser();
        localUser.setUsername(userFormDTO.username());
        localUser.setUsername(userFormDTO.password());
        localUser.setRole("USER");


        if (userFormDTO.username() != null && userFormDTO.password() != null) {
            userRepository.save(localUser);
        }
    }
}
