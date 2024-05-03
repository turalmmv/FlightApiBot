package com.example.flightapibot.service;

import com.example.flightapibot.client.FlightApiClient;
import com.example.flightapibot.client.TenslogFeignClient;
import com.example.flightapibot.dto.requestDto.TenslogRequestDto;
import com.example.flightapibot.dto.responseDto.flightResponseDto.Model;
import com.example.flightapibot.dto.responseDto.flightResponseDto.Row;
import com.example.flightapibot.dto.responseDto.telegramResponseDto.Message;
import com.example.flightapibot.dto.responseDto.telegramResponseDto.Root;
import lombok.Data;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class TenslogService {
    private final FlightApiClient flightApiClient;
    private final TenslogFeignClient tenslogFeignClient;
    private Long lastUpdateId = 0L;


    public void sendMessage(TenslogRequestDto requestDto) {
        tenslogFeignClient.sendMessage(requestDto);
    }


    //    @Scheduled(fixedRate = 1000)
    public void sendHello() {
        Root updates = getUpdates();
        int id = updates.getResult().get(0).getMessage().chat.getId();

        TenslogRequestDto tenslogRequestDto = new TenslogRequestDto();
        tenslogRequestDto.setChat_id(String.valueOf(id));

        String text = " ";
//        for (Result r : updates.getResult()) {
//            if (r.message.text.equalsIgnoreCase("salam")) {
//
//                tenslogRequestDto.setText(text);
//                sendMessage(tenslogRequestDto);
//            }
//        }
        Message message = updates.getResult().get(updates.getResult().size() - 1).message;
        String text1 = message.text;
        if (text1.contains("salam")) {
            text = "salam " + message.chat.first_name;
        }
        else if(text1.contains("aircraft")){
            text = "------------------AIRCRAFTS------------------";
            ArrayList<Row> aircraftRows = flightApiClient.getUpdates("flight-radar1.p.rapidapi.com",
                    "ec2d8e0644msh4df2335f9b27815p1ff967jsnf1c727d0ea50").getRows();
            int count = 0;
            for (Row row : aircraftRows){
                ArrayList<Model> models = row.models;
                for (Model model : models){
                    count++;
                    String name = model.name;
                    text = text + "\n#" + count + "   " + name;
                }
            }
        }
        tenslogRequestDto.setText(text);
        sendMessage(tenslogRequestDto);
    }

//    public void sendAircrafts() {
//        TenslogRequestDto tenslogRequestDto = new TenslogRequestDto();
//        Root updates = getUpdates();
//        Message message = updates.getResult().get(updates.getResult().size() - 1).message;
//        tenslogRequestDto.setChat_id(String.valueOf(updates.getResult().get(0).getMessage().chat.getId()));
//
//        if (message.text.contains("aircraft")) {
//            tenslogRequestDto.setText("");
//        }
//            tenslogFeignClient.sendAircrafts(tenslogRequestDto);
//
//    }

    @Scheduled(fixedRate = 1000)
    public void refresh() {
        Long lastId = getLastUpdateId();
        if (lastId > lastUpdateId) {
            lastUpdateId = lastId;
            sendHello();
//            sendAircrafts();
        }
    }


    public Long getLastUpdateId() {
        Root updates = tenslogFeignClient.getUpdates(0L);
        return (long) updates.getResult().get(updates.getResult().size() - 1).getUpdate_id();
    }


    public Root getUpdates() {
        return tenslogFeignClient.getUpdates(getLastUpdateId());
    }


}
