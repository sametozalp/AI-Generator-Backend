package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreateAiToolRequest extends BaseCreateRequest {

    private List<String> categories;

    private int costs;

    private int description;

    private int icon;

    private String mediaType;

    private String name;

    private String prompt;

    private String requestType;

    private String visibility;
}
