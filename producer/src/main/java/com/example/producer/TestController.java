package com.example.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final ProducerService producerService;

    @PutMapping(value = "/test/{id}")
    public ResponseEntity<Void> test(@PathVariable UUID id, @RequestBody ProducerDto producerDto) {
        producerService.send(id, producerDto);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
