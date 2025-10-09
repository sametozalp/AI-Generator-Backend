package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateRoleRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.RoleResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.Role;
import com.ozalp.AI.Generator.Backend.enums.RoleType;

public interface RoleService extends BaseService<Role> {

    Role getByName(RoleType roleType);

    Role create(Role role);

}
