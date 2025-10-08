package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.entities.abstracts.BaseEntity;

import java.util.UUID;

public interface BaseService<T extends BaseEntity, REQ extends BaseCreateRequest, RES extends BaseResponse> {

    DataResult<RES> create(REQ request);

    Result delete(UUID id);

    T getById(UUID id);

    T save(T entity);


}