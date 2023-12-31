package com.merveadler.config.rabbitmq;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Value("${rabbitmq.queueElasticRegister}")
    private String queueElasticRegister;

    @Bean
    Queue queueElasticRegister(){
        return new Queue(queueElasticRegister);
    }
}
