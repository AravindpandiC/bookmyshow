package com.example.bookmyshow.service.interfacelayer;


import com.example.bookmyshow.dto.entry.UserDto;
import com.example.bookmyshow.dto.response.UserResponseDto;

public interface UserServiceInterface {

    void saveUser(UserDto userDto);

    UserResponseDto getUser(int id);
}
