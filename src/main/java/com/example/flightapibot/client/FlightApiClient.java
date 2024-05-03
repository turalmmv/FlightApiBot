package com.example.flightapibot.client;

import com.example.flightapibot.dto.responseDto.flightResponseDto.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "flightRadar", url = "https://flight-radar1.p.rapidapi.com/aircrafts/list")
public interface FlightApiClient {

    @GetMapping()
    Root getUpdates(@RequestHeader("X-RapidAPI-Host") String host,
                    @RequestHeader("X-RapidAPI-Key") String apiKey
    );

}
