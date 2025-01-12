/*package com.example.Luana_Nature.service;

import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.Luana_Nature.config.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;

    public void addUser(String name, String email, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(securityConfig.encoder().encode(password));
        user.setRole("user");
        userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User-ul nu a fost găsit!");
        }

        return new MyUserPrincipal(user);


    }
}*/

