package com.scaleup.notesharing.auth;

import com.scaleup.notesharing.exceptions.NoSuchUserException;
import com.scaleup.notesharing.models.User;
import com.scaleup.notesharing.repositores.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty())
            throw new NoSuchUserException("No such user with email " + email);
        return new CustomUserDetails(user.get());
    }
}
