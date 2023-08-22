package com.merveadler.mapper;

import com.merveadler.rabbitmq.model.RegisterElasticModel;
import com.merveadler.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IElasticMapper {
    IElasticMapper INSTANCE = Mappers.getMapper(IElasticMapper.class);

    UserProfile fromElasticToUserProfile(final RegisterElasticModel registerElasticModel);
}
