package com.merveadler.mapper;

import com.merveadler.dto.request.RegisterRequestDto;
import com.merveadler.dto.request.UpdateEmailOrUsernameRequestDto;
import com.merveadler.dto.response.RegisterResponseDto;
import com.merveadler.rabbitmq.model.RegisterMailModel;
import com.merveadler.rabbitmq.model.RegisterModel;
import com.merveadler.model.entity.Auth;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth fromRequestDtoToAuth(final RegisterRequestDto dto);

    @Mapping(source = "id", target = "authId")
    RegisterModel fromAuthToRegisterModel(final Auth auth);

    RegisterMailModel fromAuthToRegisterMailModel(final Auth auth);

    RegisterResponseDto fromAuthToResponseDto(final Auth auth);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUsernameOrEmail(UpdateEmailOrUsernameRequestDto dto, @MappingTarget Auth auth);
}
