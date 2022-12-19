package com.example.bookmyshow.convertor;


import com.example.bookmyshow.dto.entry.UserDto;
import com.example.bookmyshow.dto.response.UserResponseDto;
import com.example.bookmyshow.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConvertor {
    public static User dtoToUser(UserDto userDto) {
        return User.builder().name(userDto.getName()).mobile(userDto.getMobile()).build();
    }

    public static UserResponseDto entityToResponse(User user) {
        return UserResponseDto.builder().name(user.getName()).
                mobile(user.getMobile()).build();
    }
}
