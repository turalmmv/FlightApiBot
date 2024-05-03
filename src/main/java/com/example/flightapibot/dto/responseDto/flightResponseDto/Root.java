package com.example.flightapibot.dto.responseDto.flightResponseDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Root{
    public int version;
    public ArrayList<Row> rows;
}
