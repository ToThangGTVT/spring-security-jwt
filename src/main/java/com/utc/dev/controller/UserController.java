package com.utc.dev.controller;

import com.utc.dev.model.User;
import com.utc.dev.repo.UserRepo;
import com.utc.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/find/{name}")
    private List<User> getByName(@PathVariable String name) {
        return userRepo.findByUsername(name);
    }

    @PostMapping(path = "/")
    private User get(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PutMapping(path = "/{username}/{name}")
    private User updateUser(@PathVariable String username, @PathVariable String name){
        return userService.update(username, name);
    }
}
