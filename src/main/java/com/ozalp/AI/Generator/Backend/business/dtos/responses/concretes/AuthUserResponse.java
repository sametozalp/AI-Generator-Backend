package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AuthUserResponse extends BaseResponse {

    UserResponse user;

    String token;

    String refreshToken;

}
