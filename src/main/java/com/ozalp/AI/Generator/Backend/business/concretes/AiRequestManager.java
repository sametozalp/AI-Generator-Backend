package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AiRequestService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiRequestResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.AiRequestMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.AiRequestRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiRequest;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AiRequestManager implements AiRequestService {

    private final AiRequestMapper mapper;
    private final AiRequestRepository repository;

    @Override
    public Result delete(UUID id) {
        AiRequest aiRequest = getById(id);
        aiRequest.markAsDeleted();
        repository.save(aiRequest);
        return new Result(true);    }

    @Override
    public AiRequest getById(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Messages.AI_REQUEST_NOT_FOUND));
    }

    @Override
    public DataResult<AiRequestResponse> create(CreateAiRequest request) {
        AiRequest aiRequest = mapper.toEntity(request);
        return new SuccessDataResult<>(mapper.toResponse(aiRequest));
    }
}
