package com.merveadler.mapper;

import com.merveadler.dto.request.CreateNewPostRequestDto;
import com.merveadler.dto.response.UserProfileResponseDto;
import com.merveadler.repository.entity.Like;
import com.merveadler.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IPostMapper {
    IPostMapper INSTANCE= Mappers.getMapper(IPostMapper.class);

    Post toPost(final CreateNewPostRequestDto dto);

    Like toLike(final UserProfileResponseDto userProfile);

}
