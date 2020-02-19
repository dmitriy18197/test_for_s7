package com.example.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProducerDto {

    private String name;
    private Integer sum;
    private Integer multiplier;

    public ProducerDto() {
    }
}
