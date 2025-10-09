package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserDetailRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserDetailResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserDetail;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDetailMapper {

    UserDetail toEntity(CreateUserDetailRequest request);

    UserDetailResponse toResponse(UserDetail userDetail);

}
