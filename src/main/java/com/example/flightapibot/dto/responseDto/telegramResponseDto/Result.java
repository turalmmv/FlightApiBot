package com.example.flightapibot.dto.responseDto.telegramResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result{
    public int update_id;
    public Message message;
}
