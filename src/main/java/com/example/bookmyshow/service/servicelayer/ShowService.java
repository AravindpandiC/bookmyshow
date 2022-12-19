package com.example.bookmyshow.service.servicelayer;

import com.example.bookmyshow.dto.entry.ShowDto;
import com.example.bookmyshow.convertor.ShowConvertor;
import com.example.bookmyshow.dto.response.ShowResponseDto;
import com.example.bookmyshow.model.*;
import com.example.bookmyshow.repository.MovieRepo;
import com.example.bookmyshow.repository.ShowRepo;
import com.example.bookmyshow.repository.ShowSeatRepo;
import com.example.bookmyshow.repository.TheatreRepo;
import com.example.bookmyshow.service.interfacelayer.ShowServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService implements ShowServiceInterface {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    ShowSeatRepo showSeatRepo;

    @Override
    public ShowResponseDto addShow(ShowDto showDto) {
        Show show = ShowConvertor.dtoToShow(showDto);

        Movie movie = movieRepo.findById(showDto.getMovieResponseDto().getId()).get();
        show.setMovie(movie);

        Theatre theatre = theatreRepo.findById(showDto.getTheatreResponseDto().getId()).get();
        show.setTheatre(theatre);

        List<ShowSeat> showSeats = getShowSeat(theatre.getTheatreSeats(),show);
        show.setShowSeats(showSeats);

        showRepo.save(show);
        showSeatRepo.saveAll(showSeats);

        ShowResponseDto showResponseDto = ShowConvertor.entityToResponse(show);
        showResponseDto.setMovie(movie.getName());
        showResponseDto.setTheatre(theatre.getName());

        return showResponseDto;
    }

    private List<ShowSeat> getShowSeat(List<TheatreSeat> theatreSeats,Show show) {
        List<ShowSeat> showSeats = new ArrayList<>();
        for(TheatreSeat seat : theatreSeats) {
            ShowSeat showSeat = ShowSeat.builder().seatNo(seat.getSeatNo()).seatType(seat.getSeatType()).
                    show(show).rate(seat.getRate()).build();
            showSeats.add(showSeat);
        }
        return showSeats;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        Show show = showRepo.findById(id).get();
        ShowResponseDto showResponseDto = ShowConvertor.entityToResponse(show);
        showResponseDto.setMovie(show.getMovie().getName());
        showResponseDto.setTheatre(show.getTheatre().getName());

        return showResponseDto;
    }
}
