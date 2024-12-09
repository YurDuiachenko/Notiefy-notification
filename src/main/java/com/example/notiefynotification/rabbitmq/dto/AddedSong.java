package com.example.notiefynotification.rabbitmq.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AddedSong implements Serializable {
    private String name;
    private String musicianNickName;
}