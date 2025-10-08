package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    void register(CreateUserRequest request);
}
