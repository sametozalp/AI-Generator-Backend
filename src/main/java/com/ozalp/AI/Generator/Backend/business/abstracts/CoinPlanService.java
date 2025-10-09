package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateCoinPlanRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.CoinPlanResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.entities.concretes.CoinPlan;

public interface CoinPlanService extends BaseService<CoinPlan> {

    DataResult<CoinPlanResponse> create(CreateCoinPlanRequest request);

}