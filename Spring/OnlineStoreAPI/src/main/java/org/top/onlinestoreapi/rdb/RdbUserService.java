package org.top.onlinestoreapi.rdb;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.Client;
import org.top.onlinestoreapi.entity.User;
import org.top.onlinestoreapi.form.UserRegistrationForm;
import org.top.onlinestoreapi.rdb.repository.ClientRepository;
import org.top.onlinestoreapi.rdb.repository.UserRepository;
import org.top.onlinestoreapi.service.ClientService;
import org.top.onlinestoreapi.service.UserService;

import java.util.Random;


@Service
public class RdbUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClientRepository clientRepository;

    public RdbUserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ClientRepository clientRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.clientRepository = clientRepository;
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
        Client client = new Client();
        Random random = new Random();
        client.setName("Клиент " + random.nextInt(99999));
        clientRepository.save(client);
        user.setClient(client);
        userRepository.save(user);
        return true;
    }
}
