package com.example.producer;

import org.apache.kafka.common.serialization.UUIDSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class ApplicationConfig {

    @Value("${kafka.server}")
    private String kafkaServer;
    @Value("${kafka.producer.id}")
    private String kafkaProducerId;

    @Bean
    public KafkaTemplate<UUID, ProducerDto> producerDtoTemplate() {
        KafkaTemplate<UUID, ProducerDto> template = new KafkaTemplate<>(producerFactory());
        template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }

    @Bean
    public ProducerFactory<UUID, ProducerDto> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfiguration());
    }

    @Bean
    public Map<String, Object> producerConfiguration() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        configs.put(KEY_SERIALIZER_CLASS_CONFIG, UUIDSerializer.class);
        configs.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configs.put(CLIENT_ID_CONFIG, kafkaProducerId);
        return configs;
    }
}
