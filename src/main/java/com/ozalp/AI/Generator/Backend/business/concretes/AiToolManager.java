package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AiToolService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiToolRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiToolResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.AiToolMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.AiToolRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiTool;
import com.ozalp.AI.Generator.Backend.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AiToolManager implements AiToolService {

    private final AiToolRepository repository;
    private final AiToolMapper mapper;

    @Override
    public DataResult<AiToolResponse> create(CreateAiToolRequest request) {
        AiTool givenData = mapper.toEntity(request);
        AiTool saved = repository.save(givenData);
        return new SuccessDataResult<>(mapper.toResponse(saved));
    }

    @Override
    public Result delete(UUID id) {
        AiTool dbUser = getById(id);
        dbUser.markAsDeleted();
        save(dbUser);
        return new Result(true);
    }

    @Override
    public AiTool getById(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Messages.AI_TOOL_NOT_FOUND));
    }

    @Override
    public AiTool save(AiTool entity) {
        return repository.save(entity);
    }
}
