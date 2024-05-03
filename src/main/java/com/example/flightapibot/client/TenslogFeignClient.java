package com.example.flightapibot.client;


import com.example.flightapibot.dto.requestDto.TenslogRequestDto;
import com.example.flightapibot.dto.responseDto.telegramResponseDto.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tenslogFeignClient", url = "https://api.telegram.org/bot7120076638:AAHzWUh6ay1CQI4UfE04k7a2hFPFgcU8hfA")
public interface TenslogFeignClient {

    @GetMapping("/getUpdates?offset={value}")
    Root getUpdates(@PathVariable Long value);

    @PostMapping("/sendAircrafts")
    void sendAircrafts(@RequestBody TenslogRequestDto tenslogRequestDto);


    @PostMapping("/sendMessage")
    void sendMessage(@RequestBody TenslogRequestDto tenslogRequestDto);


}
