package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;

public interface UserService extends BaseService<User, CreateUserRequest, UserResponse> {

    User create(User user);

}
