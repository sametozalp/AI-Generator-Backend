package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.UserRoleService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRoleRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserRoleResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserRoleMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.UserRoleRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserRoleManager implements UserRoleService {

    private final UserRoleMapper mapper;
    private final UserRoleRepository repository;

//    @Transactional
//    @Override
//    public DataResult<UserRoleResponse> create(CreateUserRoleRequest request) {
//        UserRole reqRole = mapper.toEntity(request);
//        UserRole saved = save(reqRole);
//        return new SuccessDataResult<>(mapper.toResponse(saved));
//    }

    @Override
    public Result delete(UUID id) {
        return null;
    }

    @Override
    public UserRole getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Messages.USER_ROLE_NOT_FOUND));
    }

//    @Override
//    public UserRole save(UserRole entity) {
//        return repository.save(entity);
//    }
}
