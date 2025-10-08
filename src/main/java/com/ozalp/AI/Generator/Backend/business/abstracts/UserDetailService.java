package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserDetail;

public interface UserDetailService extends BaseService<UserDetail, CreateUserRequest, UserResponse> {
}
