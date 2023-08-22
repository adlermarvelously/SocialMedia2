package com.merveadler.rabbitmq.consumer;

import com.merveadler.rabbitmq.model.RegisterElasticModel;
import com.merveadler.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElasticRegisterConsumer {
    private final UserProfileService userProfileService;

    @RabbitListener(queues = ("${rabbitmq.queueElasticRegister}"))
    public void createNewUser(RegisterElasticModel registerElasticModel){
        userProfileService.createUserWithRabbitMq(registerElasticModel);
    }
}
