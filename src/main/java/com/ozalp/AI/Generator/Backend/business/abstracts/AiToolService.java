package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiToolRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiToolResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiTool;

public interface AiToolService extends BaseService<AiTool, CreateAiToolRequest, AiToolResponse> {

}