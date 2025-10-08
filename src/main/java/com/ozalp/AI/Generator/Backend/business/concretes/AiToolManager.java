package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AiToolService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiToolRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiToolResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.dataAccess.AiToolRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
public class AiToolManager implements AiToolService {

    private final AiToolRepository repository;

    @Override
    public DataResult<AiToolResponse> create(CreateAiToolRequest request) {
        return null;
    }

    @Override
    public DataResult<AiToolResponse> update(CreateAiToolRequest request) {
        return null;
    }

    @Override
    public Result delete(UUID id) {
        return null;
    }

    @Override
    public DataResult<AiToolResponse> getById(UUID id) {
        return null;
    }

    @Override
    public DataResult<List<AiToolResponse>> getAll() {
        return null;
    }
}
