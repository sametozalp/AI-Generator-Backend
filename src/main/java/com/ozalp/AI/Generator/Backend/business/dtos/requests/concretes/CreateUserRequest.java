package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateUserRequest extends BaseCreateRequest {

    private String name;

    private String surname;

    private String email;

    private String password;

}
