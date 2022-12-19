package com.example.bookmyshow.service.servicelayer;

import com.example.bookmyshow.convertor.TicketConvertor;
import com.example.bookmyshow.dto.entry.UserDto;
import com.example.bookmyshow.convertor.UserConvertor;
import com.example.bookmyshow.dto.response.TicketResponseDto;
import com.example.bookmyshow.dto.response.UserResponseDto;
import com.example.bookmyshow.model.Ticket;
import com.example.bookmyshow.model.User;
import com.example.bookmyshow.repository.UserRepo;
import com.example.bookmyshow.service.interfacelayer.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepo userRepo;
    @Override
    public void saveUser(UserDto userDto) {
        User user = UserConvertor.dtoToUser(userDto);
        userRepo.save(user);
    }

    @Override
    public UserResponseDto getUser(int id) {
        User user = userRepo.findById(id).orElse(null);

        List<Ticket> ticketList = user.getTickets();
        List<TicketResponseDto> ticketResponseDtoList = new ArrayList<>();

        for(Ticket ticket:ticketList){
            ticketResponseDtoList.add(TicketConvertor.entityToResponse(ticket));
        }

        UserResponseDto userResponseDto = UserConvertor.entityToResponse(user);
        userResponseDto.setTicketResponseDtoList(ticketResponseDtoList);

        return userResponseDto;
    }
}
