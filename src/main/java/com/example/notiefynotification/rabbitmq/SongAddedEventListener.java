package com.example.notiefynotification.rabbitmq;


import com.example.notiefynotification.rabbitmq.dto.AddedSong;
import com.example.notiefynotification.service.NotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SongAddedEventListener {
    private static final String queueName = "songAdded";

    private final ObjectMapper objectMapper;
    private final NotificationService notificationService;

    @RabbitListener(queues = queueName)
    public void listen(String massage) {
        AddedSong song;
        try {
            song = objectMapper.readValue(massage, AddedSong.class);
            System.out.println(song);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        notificationService.sendAddedSong(song);
    }
}