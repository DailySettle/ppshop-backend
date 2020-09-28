package mingli.ppshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import mingli.ppshop.entity.User;
import mingli.ppshop.models.AuthRequest;
import mingli.ppshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Log
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void signup(AuthRequest authRequest) {
        User newUser = new User(authRequest.getUsername(), passwordEncoder.encode(authRequest.getPassword()), true, "ROLE_USER");
        userRepository.save(newUser);
        log.info("new user is saved with" + newUser.getId());
    }
}
