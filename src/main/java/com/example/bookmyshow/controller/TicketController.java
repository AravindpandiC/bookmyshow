package com.example.bookmyshow.controller;

import com.example.bookmyshow.dto.entry.BookingDto;
import com.example.bookmyshow.dto.response.TicketResponseDto;
import com.example.bookmyshow.service.servicelayer.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookticket")
    public TicketResponseDto bookTicket(@RequestBody BookingDto bookingDto){
     return ticketService.addTicket(bookingDto);
    }

    @GetMapping("/getticket/{id}")
    public TicketResponseDto getTicker(@PathVariable int id){
        return ticketService.getTicket(id);
    }
}
