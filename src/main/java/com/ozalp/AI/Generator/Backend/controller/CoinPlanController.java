package com.ozalp.AI.Generator.Backend.controller;

import com.ozalp.AI.Generator.Backend.business.abstracts.CoinPlanService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateCoinPlanRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coinPlan")
@AllArgsConstructor
public class CoinPlanController {

    private final CoinPlanService coinPlanService;

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody CreateCoinPlanRequest request) {
        return ResponseEntity.ok(coinPlanService.create(request));
    }
}
