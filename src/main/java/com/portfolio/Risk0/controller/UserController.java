package com.portfolio.Risk0.controller;

import com.portfolio.Risk0.model.User;
import com.portfolio.Risk0.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser() {
        return userService.getUser()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User savedUser = userService.updateUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
