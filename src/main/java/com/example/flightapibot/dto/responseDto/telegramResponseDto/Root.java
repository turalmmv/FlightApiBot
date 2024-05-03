package com.example.flightapibot.dto.responseDto.telegramResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class Root{
    public boolean ok;
    public ArrayList<Result> result;
}
