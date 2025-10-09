package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiRequestResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiRequest;

public interface AiRequestService extends BaseService<AiRequest> {

    DataResult<AiRequestResponse> create(CreateAiRequest request);

}
