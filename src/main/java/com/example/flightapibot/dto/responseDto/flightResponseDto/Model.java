package com.example.flightapibot.dto.responseDto.flightResponseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Model{
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Code")
    public String code;
}
