package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AuthService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserDetailService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;
    private final UserDetailService userDetailService;

    @Override
    public void register(CreateUserRequest request) {

    }

}
