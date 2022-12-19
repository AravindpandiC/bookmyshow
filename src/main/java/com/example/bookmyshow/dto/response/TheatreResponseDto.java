package com.example.bookmyshow.dto.response;

import com.example.bookmyshow.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreResponseDto {
    private int id;
    String name;
    String address;
    String city;
    TheatreType type;
}
