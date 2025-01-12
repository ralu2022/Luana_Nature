package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {return userRepository.findAll();}

    public User findByUserName(String userName) {
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User-ul nu a fost găsit!"));
    }

    public void addUser(String name, String email, String username, String password, String role) {
        role = "user";
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userRepository.save(user);
    }

    public void updateUser(Long id, User user){
        User newUser = userRepository.findById(id).orElseThrow(() ->new RuntimeException("User-ul nu a fost găsit!"));
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
