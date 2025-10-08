package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRoleRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserRoleResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    UserRole toEntity(CreateUserRoleRequest request);

    UserRoleResponse toResponse(UserRole userRole);

}
