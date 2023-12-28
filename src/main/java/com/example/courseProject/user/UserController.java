package com.example.courseProject.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/")
    public List<User> showAll()
    {
        return userService.findAll();
    }

   }
