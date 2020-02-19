package com.example.consumer;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@RequiredArgsConstructor
@ToString
public class MultipliedSumResult {

    private final UUID id;
    private final String name;
    private final String multipliedSum;

}
