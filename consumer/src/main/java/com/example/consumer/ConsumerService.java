package com.example.consumer;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(id = "Producer", topics = {"${kafka.topics.test}"}, containerFactory = "containerFactory")
    public void consume(
            ProducerDto dto,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) UUID id
    ) {
        log.info("Received new message: id - {}, value - {}", id, dto.toString());
        MultipliedSumResult result = getMultipliedSumResult(id, dto);
        log.debug("Processed message: {}", result.toString());
    }

    private MultipliedSumResult getMultipliedSumResult(UUID id, ProducerDto dto) {
        Integer multipliedSum = dto.getSum() * dto.getMultiplier();
        return new MultipliedSumResult(id, dto.getName(), String.valueOf(multipliedSum));
    }
}
