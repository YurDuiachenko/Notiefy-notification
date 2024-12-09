package com.example.notiefynotification.config;

import lombok.Getter;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.song-added.queue}")
    private String songAddedQueueName;

    @Bean
    public Queue myQueue() {
        return new Queue(songAddedQueueName, false);
    }
}