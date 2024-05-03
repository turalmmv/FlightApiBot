package com.example.flightapibot.controller;

import com.example.flightapibot.dto.requestDto.TenslogRequestDto;
import com.example.flightapibot.dto.responseDto.telegramResponseDto.Root;
import com.example.flightapibot.service.TenslogService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenslog")
@Data
public class TenslogController {
    private final TenslogService tenslogService;

    @GetMapping("/getUpdates")
    public Root getUpdates(){
       return tenslogService.getUpdates();
    }

//    public void refresh(){
//        tenslogService.refresh();
//    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody TenslogRequestDto tenslogRequestDto){
        tenslogService.sendMessage(tenslogRequestDto);
    }

}
