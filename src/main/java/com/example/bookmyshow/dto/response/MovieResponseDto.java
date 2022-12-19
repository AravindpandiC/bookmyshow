package com.example.bookmyshow.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class MovieResponseDto {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private List<String> theatreList;
}
