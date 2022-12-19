package com.example.bookmyshow.service.servicelayer;

import com.example.bookmyshow.dto.entry.TheatreDto;
import com.example.bookmyshow.convertor.TheatreConvertor;
import com.example.bookmyshow.dto.response.TheatreResponseDto;
import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.model.Theatre;
import com.example.bookmyshow.model.TheatreSeat;
import com.example.bookmyshow.repository.TheatreRepo;
import com.example.bookmyshow.repository.TheatreSeatRepo;
import com.example.bookmyshow.service.interfacelayer.TheatreServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService implements TheatreServiceInterface {

    @Autowired
    private TheatreSeatRepo theatreSeatRepo;

    @Autowired
    private TheatreRepo theatreRepo;

    @Override
    public TheatreResponseDto addTheatre(TheatreDto theatreDto) {
        Theatre theatre = TheatreConvertor.dtoToTheatre(theatreDto);
        List<TheatreSeat> seats = new ArrayList<>();
        seats.add(createSeat("A1",120, SeatType.REGULAR));
        seats.add(createSeat("A2",120, SeatType.REGULAR));
        seats.add(createSeat("A3",120, SeatType.REGULAR));

        seats.add(createSeat("B1",150, SeatType.PREMIUM));
        seats.add(createSeat("B2",150, SeatType.PREMIUM));
        seats.add(createSeat("B3",150, SeatType.PREMIUM));

        for(TheatreSeat theatreSeat:seats) theatreSeat.setTheatre(theatre);

        theatreRepo.save(theatre);
        theatreSeatRepo.saveAll(seats);

        TheatreResponseDto theatreResponseDto = TheatreConvertor.theatreToResponse(theatre);

        return theatreResponseDto;
    }

    private TheatreSeat createSeat(String seatNo, int rate, SeatType seatType){
        return TheatreSeat.builder().seatNo(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        Theatre theatre = theatreRepo.findById(id).get();
        TheatreResponseDto theatreResponseDto = TheatreConvertor.theatreToResponse(theatre);
        return theatreResponseDto;
    }
}
