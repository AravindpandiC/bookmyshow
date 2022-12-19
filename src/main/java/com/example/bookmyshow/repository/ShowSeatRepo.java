package com.example.bookmyshow.repository;


import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepo extends JpaRepository<ShowSeat,Integer> {

    List<ShowSeat> findByShow(Show show);
}
