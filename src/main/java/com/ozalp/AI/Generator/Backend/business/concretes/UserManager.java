package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.UserRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public DataResult<UserResponse> create(CreateUserRequest request) {
        User givenUser = mapper.toEntity(request);
        User saved = save(givenUser);
        return new SuccessDataResult<>(mapper.toResponse(saved));
    }

    @Override
    public Result delete(UUID id) {
        User dbUser = getById(id);
        dbUser.markAsDeleted();
        save(dbUser);
        return new Result(true);
    }

    @Override
    public User getById(UUID id) {
        return repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(Messages.User_NOT_FOUND));
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }
}
