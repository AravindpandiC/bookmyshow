package com.example.bookmyshow.convertor;

import com.example.bookmyshow.dto.entry.TheatreDto;
import com.example.bookmyshow.dto.response.TheatreResponseDto;
import com.example.bookmyshow.model.Theatre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConvertor {

    public static Theatre dtoToTheatre(TheatreDto theatreDto) {
        return Theatre.builder().name(theatreDto.getName()).address(theatreDto.getAddress()).city(theatreDto.getCity()).
                theatreType(theatreDto.getTheatreType()).build();
    }


    public static TheatreResponseDto theatreToResponse(Theatre theatre) {
        return TheatreResponseDto.builder().id(theatre.getId()).name(theatre.getName()).city(theatre.getCity()).
                address(theatre.getAddress()).type(theatre.getTheatreType()).build();
    }
}
