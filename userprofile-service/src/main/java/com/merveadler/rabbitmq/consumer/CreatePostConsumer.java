package com.merveadler.rabbitmq.consumer;

import com.merveadler.rabbitmq.model.CreatePostModel;
import com.merveadler.rabbitmq.model.UserProfileResponseModel;
import com.merveadler.repository.entity.UserProfile;
import com.merveadler.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreatePostConsumer {
    private final UserProfileService userProfileService;

    @RabbitListener(queues = ("${rabbitmq.queueCreatePost}"))
    public Object createPost(CreatePostModel model){
        Optional<UserProfile> userProfile = userProfileService.findByAuthId(model.getAuthId());
        UserProfileResponseModel userProfileResponseModel = UserProfileResponseModel.builder()
                .userId(userProfile.get().getId())
                .username(userProfile.get().getUsername())
                .avatar(userProfile.get().getAvatar())
                .build();
        return userProfileResponseModel;
    }
}
