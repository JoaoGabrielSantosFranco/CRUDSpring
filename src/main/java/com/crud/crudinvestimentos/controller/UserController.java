package com.crud.crudinvestimentos.controller;

import com.crud.crudinvestimentos.entity.User;
import com.crud.crudinvestimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);

        return ResponseEntity.created(URI.create("/users/" + userId.toString())).build();
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {

        return null;
    }


}
