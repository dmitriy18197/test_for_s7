package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<UUID, ProducerDto> producerDtoTemplate;

    @Value("${kafka.topics.test}")
    private String topic;

    public void send(UUID id, ProducerDto producerDto) {
        producerDtoTemplate.send(topic, id, producerDto);
    }

}
