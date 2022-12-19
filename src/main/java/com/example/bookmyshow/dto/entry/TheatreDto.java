package com.example.bookmyshow.dto.entry;


import com.example.bookmyshow.enums.TheatreType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TheatreDto {


    private String name;

    private TheatreType theatreType; //missing

    private String address;

    private String city;
}
