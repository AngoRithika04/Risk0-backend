package com.portfolio.Risk0.service;

import com.portfolio.Risk0.model.User;
import com.portfolio.Risk0.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUser() {
        return userRepository.findAll().stream().findFirst();
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findAll().stream()
                .findFirst()
                .orElse(new User());

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());

        return userRepository.save(existingUser);
    }
}
