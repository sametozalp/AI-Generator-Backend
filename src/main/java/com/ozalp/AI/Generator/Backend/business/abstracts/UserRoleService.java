package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRoleRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserRoleResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;

import java.util.List;

public interface UserRoleService extends BaseService<UserRole> {
    UserRole create(UserRole userRole);

    List<UserRole> getAllByUser(User user);
}
