package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateRoleRequest extends BaseCreateRequest {

    private RoleType name;

}
