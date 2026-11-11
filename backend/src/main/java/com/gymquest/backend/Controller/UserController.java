package com.gymquest.backend.Controller;

import com.gymquest.backend.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/test")
    public User getTestUser() {
        // Create a dummy user to test the connection
        User dummyUser = new User();
        dummyUser.setId(1L);
        dummyUser.setUsername("GymBro99");
        dummyUser.setEmail("gymbro@test.com");
        dummyUser.setCurrent_xp(150);
        dummyUser.setLevel(2);

        return dummyUser; // Spring Boot automatically converts this Java object into JSON
    }
}