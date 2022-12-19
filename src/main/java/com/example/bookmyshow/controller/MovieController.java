package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entry.MovieDto;
import com.example.bookmyshow.dto.response.MovieResponseDto;
import com.example.bookmyshow.service.servicelayer.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addmovie")
    public MovieResponseDto addMovie(@RequestBody MovieDto movieDto){
        return movieService.addMovie(movieDto);
    }

    @GetMapping("/getmovie/{id}")
    public MovieResponseDto getMovie(@PathVariable int id){
        return movieService.getMovie(id);
    }
}
