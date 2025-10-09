package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDetailResponse extends BaseResponse {

    private UserResponse user;

    private String profileImage;

    private String lang;

    private String deviceToken;

    private int coin;

    private String phoneNumber;
}
