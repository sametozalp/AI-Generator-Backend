package com.ozalp.AI.Generator.Backend.entities.concretes;

import com.ozalp.AI.Generator.Backend.entities.abstracts.BaseEntity;
import com.ozalp.AI.Generator.Backend.enums.PurchaseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coin_plans")
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinPlan extends BaseEntity {

    @Column(name = "coins", nullable = false)
    private int coins;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PurchaseType type;

    @Column(name = "visibility", nullable = false)
    private Boolean visibility;

    @Column(name = "purchase_id_in_google_play", nullable = false)
    private String purchaseIdInGooglePlay;
}
