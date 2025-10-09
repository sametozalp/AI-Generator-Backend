package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.CoinPlanService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateCoinPlanRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.CoinPlanResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.CoinPlanMapper;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.CoinPlanRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.CoinPlan;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CoinPlanManager implements CoinPlanService {

    private final CoinPlanMapper mapper;
    private final CoinPlanRepository repository;

    @Override
    public Result delete(UUID id) {
        CoinPlan coinPlan = getById(id);
        coinPlan.markAsDeleted();
        repository.save(coinPlan);
        return new Result(true);
    }

    @Override
    public CoinPlan getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Messages.COIN_PLAN_NOT_FOUND));
    }

    @Override
    public DataResult<CoinPlanResponse> create(CreateCoinPlanRequest request) {
        CoinPlan coinPlan = mapper.toEntity(request);
        return new SuccessDataResult<>(mapper.toResponse(repository.save(coinPlan)));
    }
}
