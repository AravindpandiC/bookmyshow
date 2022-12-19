package com.example.bookmyshow.convertor;

import com.example.bookmyshow.dto.response.TicketResponseDto;
import com.example.bookmyshow.model.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConvertor {
    public static TicketResponseDto entityToResponse(Ticket ticket) {
        return TicketResponseDto.builder().show(ticket.getShow().getMovie().getName()).
                seat(ticket.getAllottedSeat()).
                theatre(ticket.getShow().getTheatre().getName()).
                amount(ticket.getAmount()).build();
    }
}
