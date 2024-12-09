package com.example.notiefynotification.service.impl;

import com.example.notiefynotification.rabbitmq.dto.AddedSong;
import com.example.notiefynotification.service.NotificationService;
import com.example.notiefynotification.ws.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationSender notificationSender;

    @Override
    public void sendAddedSong(AddedSong song) {
        String message = String.format("%s released new song: \"%s\"!", song.getMusicianNickName(), song.getName());
        notificationSender.send(message);
    }
}