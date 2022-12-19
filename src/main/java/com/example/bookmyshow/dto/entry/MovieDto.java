package com.example.bookmyshow.dto.entry;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MovieDto {

    private String name;
    private LocalDate releaseDate;

}
