package com.example.bookmyshow.service.interfacelayer;

import com.example.bookmyshow.dto.entry.TheatreDto;
import com.example.bookmyshow.dto.response.TheatreResponseDto;

public interface TheatreServiceInterface {

    TheatreResponseDto addTheatre(TheatreDto theatreDto);
    TheatreResponseDto getTheatre(int id);
}
