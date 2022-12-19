package com.example.bookmyshow.service.servicelayer;


import com.example.bookmyshow.dto.entry.MovieDto;
import com.example.bookmyshow.convertor.MovieConvertor;
import com.example.bookmyshow.dto.response.MovieResponseDto;
import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.Theatre;
import com.example.bookmyshow.repository.MovieRepo;
import com.example.bookmyshow.service.interfacelayer.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepo movieRepo;
    @Override
    public MovieResponseDto addMovie(MovieDto movieDto) {
        MovieResponseDto movieResponseDto = null;
        if(movieRepo.existsByName(movieDto.getName())) {
            movieResponseDto.setName("Movie exists");
            return movieResponseDto;
        }
        Movie movie = MovieConvertor.dtoToEntity(movieDto);
        movieRepo.save(movie);

        movieResponseDto=MovieConvertor.entityToDto(movie);

        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        Movie movie = movieRepo.findById(id).get();
        MovieResponseDto movieResponseDto = MovieConvertor.entityToDto(movie);

        List<Show> shows= movie.getShows();
        List<String> theatres = new ArrayList<>();

        for(Show show:shows){
            theatres.add(show.getTheatre().getName());
        }

        movieResponseDto.setTheatreList(theatres);
        return movieResponseDto;
    }
}
