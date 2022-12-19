package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entry.UserDto;
import com.example.bookmyshow.dto.response.UserResponseDto;
import com.example.bookmyshow.service.servicelayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public void addUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @GetMapping("/getuser/{id}")
    public UserResponseDto getUser(@PathVariable int id){
        return userService.getUser(id);
    }
}
