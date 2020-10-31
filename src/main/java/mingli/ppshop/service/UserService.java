package mingli.ppshop.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import mingli.ppshop.Exception.UserEmailExistException;
import mingli.ppshop.entity.User;
import mingli.ppshop.models.AuthRequest;
import mingli.ppshop.dao.UserDao;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@Log
public class UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    public void signup(AuthRequest authRequest) throws UserEmailExistException {
        if (userDao.findByUsername(authRequest.getUsername()).isPresent()) {
            throw new UserEmailExistException("User email " + authRequest.getUsername() + " existed");
        }
        User newUser = new User(authRequest.getUsername(), passwordEncoder.encode(authRequest.getPassword()), true, "ROLE_USER");
        userDao.save(newUser);
        log.info("new user is saved with id " + newUser.getId());
    }
}
