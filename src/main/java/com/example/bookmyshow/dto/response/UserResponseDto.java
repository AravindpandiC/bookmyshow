package com.example.bookmyshow.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data@Builder
public class UserResponseDto {
    private String name;
    private String mobile;
    private List<TicketResponseDto> ticketResponseDtoList;
}
