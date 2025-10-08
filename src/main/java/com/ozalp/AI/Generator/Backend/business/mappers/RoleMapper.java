package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateRoleRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.RoleResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse toResponse(Role role);

    Role toEntity(CreateRoleRequest request);
}
