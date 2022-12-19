package com.example.bookmyshow.service.servicelayer;

import com.example.bookmyshow.convertor.TicketConvertor;
import com.example.bookmyshow.dto.entry.BookingDto;
import com.example.bookmyshow.dto.response.TicketResponseDto;
import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeat;
import com.example.bookmyshow.model.Ticket;
import com.example.bookmyshow.model.User;
import com.example.bookmyshow.repository.ShowRepo;
import com.example.bookmyshow.repository.ShowSeatRepo;
import com.example.bookmyshow.repository.TicketRepo;
import com.example.bookmyshow.repository.UserRepo;
import com.example.bookmyshow.service.interfacelayer.TicketSeviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class TicketService implements TicketSeviceInterface {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ShowRepo showRepo;

    @Autowired
    ShowSeatRepo showSeatRepo;

    @Autowired
    TicketRepo ticketRepo;

    @Override
    public TicketResponseDto addTicket(BookingDto bookingDto) {

       User user = userRepo.findById(bookingDto.getUserId()).get();
       Show show = showRepo.findById(bookingDto.getShowId()).get();
//       SeatType seatType = bookingDto.getSeatType();
       Set<String> selectedSeats = bookingDto.getSelectedSeats();

       List<ShowSeat> showSeatList = show.getShowSeats();
       List<ShowSeat> bookedSeats = new ArrayList<>();

       for(ShowSeat showSeat : showSeatList) {
           String seatNo = showSeat.getSeatNo();
           if(selectedSeats.contains(seatNo)) {
               if(showSeat.isBooked()) throw new Error("Booked");
               else bookedSeats.add(showSeat);
           }
       }

       Ticket ticket = Ticket.builder().show(show).user(user).showSeats(bookedSeats).build();
       int amount =0;
       for(ShowSeat showSeat : bookedSeats){
           amount+=showSeat.getRate();
           showSeat.setBooked(true);
           showSeat.setTicket(ticket);
           showSeat.setBookedAt(new Date());
       }

       ticket.setAmount(amount);
       ticket.setBookedAt(new Date());
       ticket.setAllottedSeat(createSeats(bookedSeats));

       ticketRepo.save(ticket);
       showSeatRepo.saveAll(bookedSeats);

       TicketResponseDto ticketResponseDto = TicketConvertor.entityToResponse(ticket);
       return ticketResponseDto;

    }

    private String createSeats(List<ShowSeat> bookedSeats) {
        StringBuilder str = new StringBuilder();
        for(ShowSeat showSeat:bookedSeats) str.append(showSeat.getSeatNo()).append(", ");
        return str.toString();
    }

    @Override
    public TicketResponseDto getTicket(int id) {
        Ticket ticket = ticketRepo.findById(id).get();
        TicketResponseDto ticketResponseDto = TicketConvertor.entityToResponse(ticket);
        return ticketResponseDto;
    }

}
