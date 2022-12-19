package com.example.bookmyshow.dto.entry;


import com.example.bookmyshow.dto.response.MovieResponseDto;
import com.example.bookmyshow.dto.response.TheatreResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShowDto {

    private LocalDate localDate;
    private LocalTime localTime;
    private MovieResponseDto movieResponseDto;
    private TheatreResponseDto theatreResponseDto;
}
