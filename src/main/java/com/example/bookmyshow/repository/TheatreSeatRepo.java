package com.example.bookmyshow.repository;


import com.example.bookmyshow.model.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepo extends JpaRepository<TheatreSeat,Integer> {
}
