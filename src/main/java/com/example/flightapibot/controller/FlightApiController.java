package com.example.flightapibot.controller;

import com.example.flightapibot.dto.responseDto.flightResponseDto.Root;
import com.example.flightapibot.service.FlightService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
@Data
public class FlightApiController {
    private final FlightService flightService;

    @GetMapping("/get-all")
    public Root getUpdates(){
        return flightService.getUpdates();
    }
}
