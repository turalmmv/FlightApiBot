package com.example.flightapibot.service;

import com.example.flightapibot.client.FlightApiClient;
import com.example.flightapibot.dto.responseDto.flightResponseDto.Root;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class FlightService {
    private final FlightApiClient flightApiClient;
    private final String host = "flight-radar1.p.rapidapi.com";
    private final String apiKey = "ec2d8e0644msh4df2335f9b27815p1ff967jsnf1c727d0ea50";

    public Root getUpdates() {
        return flightApiClient.getUpdates(host,apiKey);
    }


}
