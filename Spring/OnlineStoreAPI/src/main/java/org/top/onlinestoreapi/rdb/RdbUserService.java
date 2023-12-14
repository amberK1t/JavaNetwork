package org.top.onlinestoreapi.rdb;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.User;
import org.top.onlinestoreapi.form.UserRegistrationForm;
import org.top.onlinestoreapi.rdb.repository.UserRepository;
import org.top.onlinestoreapi.service.UserService;


@Service
public class RdbUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RdbUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean register(UserRegistrationForm userRegistrationForm) {
        if (!userRegistrationForm.getPassword().equals(userRegistrationForm.getPasswordConfirm())) {
            return false;
        }
        if (userRepository.findByLogin(userRegistrationForm.getLogin()).isPresent()) {
            return false;
        }
        User user = new User();
        user.setLogin(userRegistrationForm.getLogin());
        String passwordHash = passwordEncoder.encode(userRegistrationForm.getPassword());
        user.setPassword(passwordHash);
        user.setRole(userRegistrationForm.getRole());
        userRepository.save(user);
        return true;
    }
}
