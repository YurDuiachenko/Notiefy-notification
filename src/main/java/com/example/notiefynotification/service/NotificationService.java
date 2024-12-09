package com.example.notiefynotification.service;

import com.example.notiefynotification.rabbitmq.dto.AddedSong;

public interface NotificationService {
    void sendAddedSong(AddedSong song);
}
