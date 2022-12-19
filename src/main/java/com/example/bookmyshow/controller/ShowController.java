package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entry.ShowDto;
import com.example.bookmyshow.dto.response.ShowResponseDto;
import com.example.bookmyshow.service.servicelayer.MovieService;
import com.example.bookmyshow.service.servicelayer.ShowService;
import com.example.bookmyshow.service.servicelayer.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    MovieService movieService;

    @Autowired
    TheatreService theatreService;

    @Autowired
    ShowService showService;

    @PostMapping("/addshow/{movieid}/{theatreid}")
    public ShowResponseDto addShow(@RequestBody ShowDto showDto, @PathVariable int movieid,@PathVariable int theatreid ){
        showDto.setMovieResponseDto(movieService.getMovie(movieid));
        showDto.setTheatreResponseDto(theatreService.getTheatre(theatreid));

        return showService.addShow(showDto);
    }

    @GetMapping("/getshow/{id}")
    public ShowResponseDto getShow(@PathVariable int id){
        return showService.getShow(id);
    }
}
