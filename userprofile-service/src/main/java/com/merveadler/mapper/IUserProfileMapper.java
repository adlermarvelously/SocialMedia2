package com.merveadler.mapper;

import com.merveadler.dto.request.*;
import com.merveadler.dto.response.UserProfileResponseDto;
import com.merveadler.rabbitmq.model.RegisterElasticModel;
import com.merveadler.rabbitmq.model.RegisterModel;
import com.merveadler.repository.entity.Follow;
import com.merveadler.repository.entity.UserProfile;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile fromDtoToUserProfile(final NewCreateUserRequestDto dto);

    UserProfile fromRegisterModelToUserProfile(final RegisterModel registerModel);

    RegisterElasticModel fromUserProfileToElasticModel(final UserProfile userProfile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProfile updateFromDtoToUserProfile(UserProfileUpdateRequestDto dto, @MappingTarget UserProfile userProfile);

    UpdateEmailOrUsernameRequestDto toUpdateUsernameEmail(final UserProfile userProfile);

    UpdateEmailOrUsernameRequestDto toUpdateUsernameEmail(final UserProfileUpdateRequestDto dto);

    Follow fromCreateFollowDtoToFollow(final String followId, final String userId);

    ToAuthPasswordChangeDto fromUserProfileToAuthPasswordChangeDto(final UserProfile userProfile);

    @Mapping(source = "id", target = "userId")
    UserProfileResponseDto fromUserProfileToResponseDto(final UserProfile userProfile);
}
