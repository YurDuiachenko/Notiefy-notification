package com.example.notiefynotification.ws;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationSender {
    private final static String DESTINATION = "/topic/notifications";

    private final SimpMessagingTemplate template;

    public void send(String message) {
        template.convertAndSend(DESTINATION, message);
    }
}