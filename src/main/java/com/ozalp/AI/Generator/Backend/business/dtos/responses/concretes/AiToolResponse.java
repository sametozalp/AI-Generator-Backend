package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;

import java.util.List;
import java.util.UUID;

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
