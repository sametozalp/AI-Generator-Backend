package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class AiToolResponse extends BaseResponse {

    private List<String> categories;

    private int costs;

    private UUID id;

    private int description;

    private int icon;

    private String mediaType;

    private String name;

    private String prompt;

    private String requestType;

    private String visibility;

}
