package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiToolRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiToolResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiTool;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AiToolMapper {

    @Mapping(target = "categories", source = "categories")
    AiToolResponse toResponse(AiTool aiTool);

    @Mapping(target = "categories", source = "categories")
    AiTool toEntity(CreateAiToolRequest request);
}
