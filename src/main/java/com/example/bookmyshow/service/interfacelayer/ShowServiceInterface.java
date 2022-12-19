package com.example.bookmyshow.service.interfacelayer;


import com.example.bookmyshow.dto.entry.ShowDto;
import com.example.bookmyshow.dto.response.ShowResponseDto;

public interface ShowServiceInterface {
    ShowResponseDto addShow(ShowDto showDto);
    ShowResponseDto getShow(int id);
}
