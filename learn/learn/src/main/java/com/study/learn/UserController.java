package com.study.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    // LOGIN endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepo.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // DO NOT send password back!
            user.setPassword(null);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    // REGISTER endpoint
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // check if username already exists
        if (userRepo.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.status(409).body("Username already exists");
        }
        // optional: You can add more validation here

        User saved = userRepo.save(user);

        // DO NOT send password back!
        saved.setPassword(null);
        return ResponseEntity.ok(saved);
    }
}
