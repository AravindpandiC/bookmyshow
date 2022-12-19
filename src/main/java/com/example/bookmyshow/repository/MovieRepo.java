package com.example.bookmyshow.repository;

import com.example.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
    boolean existsByName(String name);
}
