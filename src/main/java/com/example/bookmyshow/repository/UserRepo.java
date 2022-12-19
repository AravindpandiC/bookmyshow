package com.example.bookmyshow.repository;


import com.example.bookmyshow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
