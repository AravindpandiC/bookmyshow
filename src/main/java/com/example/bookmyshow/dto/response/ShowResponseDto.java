package com.example.bookmyshow.dto.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Data
public class ShowResponseDto {
    LocalDate showDate;

    LocalTime showTime;

    String movie;

    String theatre;
}
