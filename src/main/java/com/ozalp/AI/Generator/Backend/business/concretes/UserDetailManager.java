package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.UserDetailService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserDetailRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserDetailResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserDetailMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.UserDetailRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserDetail;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserDetailManager implements UserDetailService {

    private final UserDetailRepository repository;
    private final UserDetailMapper mapper;

//    @Transactional
//    @Override
//    public DataResult<UserDetailResponse> create(CreateUserDetailRequest request) {
//        UserDetail userDetailRequest = mapper.toEntity(request);
//        UserDetail saved = save(userDetailRequest);
//        return new SuccessDataResult<>(mapper.toResponse(saved));
//    }

    @Override
    public Result delete(UUID id) {
        UserDetail dbDetail = getById(id);
        dbDetail.markAsDeleted();
        repository.save(dbDetail);
        return new Result(true);
    }

    @Override
    public UserDetail getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(Messages.USER_DETAIL_NOT_FOUND));
    }
//
//    @Override
//    public UserDetail save(UserDetail entity) {
//        return repository.save(entity);
//    }
}
