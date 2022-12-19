package com.example.bookmyshow.convertor;


import com.example.bookmyshow.dto.entry.ShowDto;
import com.example.bookmyshow.dto.response.ShowResponseDto;
import com.example.bookmyshow.model.Show;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConvertor {

    public static Show dtoToShow(ShowDto showDto) {
        return Show.builder().localDate(showDto.getLocalDate()).localTime(showDto.getLocalTime()).build();
    }

    public static ShowResponseDto entityToResponse(Show show) {
        return ShowResponseDto.builder().showDate(show.getLocalDate()).showTime(show.getLocalTime()).build();
    }
}
