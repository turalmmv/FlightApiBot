package com.example.flightapibot.dto.responseDto.telegramResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message{
    public int message_id;
    public From from;
    public Chat chat;
    public int date;
    public String text;
}
