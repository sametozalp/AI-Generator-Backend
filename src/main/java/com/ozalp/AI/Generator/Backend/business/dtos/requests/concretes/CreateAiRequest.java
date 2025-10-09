package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import com.ozalp.AI.Generator.Backend.enums.RequestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateAiRequest extends BaseCreateRequest {

    private UUID aiToolId;

    private UUID userId;

    private String imageSize;

    private List<String> resultMedia;

    private List<String> uploadMedia;

    private int variants;

}
