package com.example.flightapibot.dto.responseDto.telegramResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat{
    public int id;
    public String first_name;
    public String last_name;
    public String username;
    public String type;
}