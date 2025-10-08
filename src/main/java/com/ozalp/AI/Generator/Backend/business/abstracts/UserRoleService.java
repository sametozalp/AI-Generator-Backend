package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRoleRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserRoleResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;

public interface UserRoleService extends BaseService<UserRole, CreateUserRoleRequest, UserRoleResponse> {
}
