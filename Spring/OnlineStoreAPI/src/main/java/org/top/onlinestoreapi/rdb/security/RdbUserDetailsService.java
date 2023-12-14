package org.top.onlinestoreapi.rdb.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.top.onlinestoreapi.entity.User;
import org.top.onlinestoreapi.rdb.repository.UserRepository;

import java.util.Optional;

@Service
public class RdbUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public RdbUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new RdbUserDetails(user.get());
    }
}
