package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.UserDetailService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.dataAccess.UserDetailRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
public class UserDetailManager implements UserDetailService {

    private final UserDetailRepository repository;

    @Override
    public DataResult<UserResponse> create(CreateUserRequest request) {
        return null;
    }

    @Override
    public DataResult<UserResponse> update(CreateUserRequest request) {
        return null;
    }

    @Override
    public Result delete(UUID id) {
        return null;
    }

    @Override
    public DataResult<UserResponse> getById(UUID id) {
        return null;
    }

    @Override
    public DataResult<List<UserResponse>> getAll() {
        return null;
    }
}
