package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.UserLoginByEmailRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AuthUserResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    DataResult<AuthUserResponse> register(CreateUserRequest request);

    DataResult<AuthUserResponse> login(UserLoginByEmailRequest request);

}
