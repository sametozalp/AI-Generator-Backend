package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateUserDetailRequest extends BaseCreateRequest {

    private User user;

    private String profileImage;

    private String lang;

    private String deviceToken;

    private int coin;

    private String phoneNumber;

}
