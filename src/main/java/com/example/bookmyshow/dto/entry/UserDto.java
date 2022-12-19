package com.example.bookmyshow.dto.entry;


import com.example.bookmyshow.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {


    @NonNull
    private String name;

    @NonNull
    private String mobile;


}
