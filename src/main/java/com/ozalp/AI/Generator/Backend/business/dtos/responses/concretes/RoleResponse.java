package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RoleResponse extends BaseResponse {

    private RoleType name;

}
