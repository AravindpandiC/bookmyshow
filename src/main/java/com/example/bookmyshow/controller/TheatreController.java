package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entry.TheatreDto;
import com.example.bookmyshow.dto.response.TheatreResponseDto;
import com.example.bookmyshow.service.servicelayer.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/addtheatre")
    public TheatreResponseDto addTheatre(@RequestBody TheatreDto theatreDto){
       return theatreService.addTheatre(theatreDto);
    }

    @GetMapping("/get/{id}")
    public TheatreResponseDto getTheatre(@PathVariable int id){
        return theatreService.getTheatre(id);
    }
}
