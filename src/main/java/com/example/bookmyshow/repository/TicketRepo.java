package com.example.bookmyshow.repository;


import com.example.bookmyshow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {
}
