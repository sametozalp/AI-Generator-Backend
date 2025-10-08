package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;

import java.util.UUID;

public class UserResponse extends BaseResponse {

    private UUID id;

    private String name;

    private String surname;

    private String email;

    private int coin;

}
