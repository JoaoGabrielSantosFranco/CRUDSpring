package com.crud.crudinvestimentos.controller;

import com.crud.crudinvestimentos.entity.User;
import com.crud.crudinvestimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
        var user = userService.getListUsers();
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return (ResponseEntity<List<User>>) ResponseEntity.notFound();
        }
    }

    @PutMapping("/{userID}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userID") String userId,
                                               @RequestBody UpdateUserDTO updateUserDTO) {

        userService.updateUserById(userId, updateUserDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{userID}")
    public ResponseEntity<Void> deleteBy(@PathVariable("userID") String userId){
         userService.deleteById(userId);

        return ResponseEntity.noContent().build();
    }
}
