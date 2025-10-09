package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateCoinPlanRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.CoinPlanResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.CoinPlan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoinPlanMapper {

    CoinPlan toEntity(CreateCoinPlanRequest request);

    CoinPlanResponse toResponse(CoinPlan coinPlan);

}
