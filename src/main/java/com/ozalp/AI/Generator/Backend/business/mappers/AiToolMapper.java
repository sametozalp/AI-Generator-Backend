package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiToolRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiToolResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiTool;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AiToolMapper {

    AiToolResponse toResponse(AiTool aiTool);

    AiTool toEntity(CreateAiToolRequest request);
}
