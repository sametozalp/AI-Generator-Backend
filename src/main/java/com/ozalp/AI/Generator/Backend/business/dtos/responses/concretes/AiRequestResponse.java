package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import com.ozalp.AI.Generator.Backend.enums.RequestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class AiRequestResponse extends BaseResponse {

    private UUID id;

    private AiToolResponse aiTool;

    private UserResponse user;

    private String imageSize;

    private Long processTime;

    private List<String> resultMedia;

    private List<String> uploadMedia;

    private int variants;

    private RequestStatus status;
}
