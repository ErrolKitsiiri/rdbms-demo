package com.example.rbdms_demo.controller;

import com.example.rbdms_demo.model.User;
import com.example.rbdms_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "User Created Successfully";
    }

    @GetMapping
    public List<Map<String, Object>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/email/{id}")
    public String updateEmail(@PathVariable int id, @RequestBody String email){
        userService.updateEmail(id, email);
        return "User email updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "User Deleted Successfully";
    }
}
