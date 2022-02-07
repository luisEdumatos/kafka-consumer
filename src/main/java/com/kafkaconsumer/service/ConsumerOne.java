package com.kafkaconsumer.service;

import com.kafkaconsumer.model.FieldModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConsumerOne {
    private final Logger LOGGER = LoggerFactory.getLogger(ConsumerOne.class);

    @KafkaListener(topics = "testeJava", groupId = "group1", containerFactory = "kafkaListenerContainerFactory")
    public void consumeUserMessage(@Payload FieldModel msg, @Headers MessageHeaders headers) throws IOException {
        System.out.println("received data in Consumer One ="+ msg);
    }
}
