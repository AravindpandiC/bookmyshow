package com.example.bookmyshow.repository;


import com.example.bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Show,Integer> {
}
