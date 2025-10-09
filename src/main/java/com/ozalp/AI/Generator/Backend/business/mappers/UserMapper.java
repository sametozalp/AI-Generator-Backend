package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);

    User toEntity(CreateUserRequest request);

}
