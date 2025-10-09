package com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.abstracts.BaseCreateRequest;
import com.ozalp.AI.Generator.Backend.enums.PurchaseType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CreateCoinPlanRequest extends BaseCreateRequest {

    private int coins;

    private PurchaseType type;

    private Boolean visibility;

    private String purchaseIdInGooglePlay;
}
