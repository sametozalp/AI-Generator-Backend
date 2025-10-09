package com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes;

import com.ozalp.AI.Generator.Backend.business.dtos.responses.abstracts.BaseResponse;
import com.ozalp.AI.Generator.Backend.enums.PurchaseType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class CoinPlanResponse extends BaseResponse {

    private UUID id;

    private int coins;

    private PurchaseType type;

    private Boolean visibility;

    private String purchaseIdInGooglePlay;
}
