package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateRoleRequest extends BaseCreateRequest {

    private RoleType name;

}
