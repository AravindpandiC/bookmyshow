package com.example.bookmyshow.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    int amount;
    String seat;
    String show;
    String theatre;
}
