package com.example.bookmyshow.dto.entry;

import com.example.bookmyshow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Builder
@Setter
@Getter
@AllArgsConstructor
public class BookingDto {
    private int userId;
    private int showId;
    Set<String> selectedSeats;
    //SeatType seatType;
}
