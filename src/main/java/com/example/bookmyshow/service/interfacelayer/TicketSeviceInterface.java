package com.example.bookmyshow.service.interfacelayer;

import com.example.bookmyshow.dto.entry.BookingDto;
import com.example.bookmyshow.dto.response.TicketResponseDto;

public interface TicketSeviceInterface {
    TicketResponseDto addTicket(BookingDto bookingDto);
    TicketResponseDto getTicket(int id);
}
