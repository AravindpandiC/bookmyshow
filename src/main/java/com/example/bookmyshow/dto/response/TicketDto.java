package com.example.bookmyshow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Builder
@Getter
@Setter
@AllArgsConstructor
public class TicketDto {

    private int amount;
    String seats;
    String user;
    String show;
    String theatre;
}
