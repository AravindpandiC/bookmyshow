package com.example.bookmyshow.convertor;

import com.example.bookmyshow.dto.entry.MovieDto;
import com.example.bookmyshow.dto.response.MovieResponseDto;
import com.example.bookmyshow.model.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConvertor {

    public static Movie dtoToEntity(MovieDto movieDto) {
        return Movie.builder().name(movieDto.getName()).releaseDate(movieDto.getReleaseDate()).build();
    }



    public static MovieResponseDto entityToDto(Movie movie) {
        return MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).releaseDate(movie.getReleaseDate()).build();
    }
}
