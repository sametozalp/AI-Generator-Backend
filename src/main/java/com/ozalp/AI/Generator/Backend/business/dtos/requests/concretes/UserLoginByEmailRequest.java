package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import lombok.Data;

@Data
public class UserLoginByEmailRequest {

    private String email;

    private String password;
}
