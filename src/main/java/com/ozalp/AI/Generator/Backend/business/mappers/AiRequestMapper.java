package com.ozalp.AI.Generator.Backend.business.mappers;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AiRequestResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AiRequestMapper {

    AiRequest toEntity(CreateAiRequest request);

    AiRequestResponse toResponse(AiRequest aiRequest);

}
