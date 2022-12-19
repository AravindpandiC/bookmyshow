package com.example.bookmyshow.service.interfacelayer;


import com.example.bookmyshow.dto.entry.MovieDto;
import com.example.bookmyshow.dto.response.MovieResponseDto;

public interface MovieServiceInterface {

    MovieResponseDto addMovie(MovieDto movieDto);
    MovieResponseDto getMovie(int id);
}
