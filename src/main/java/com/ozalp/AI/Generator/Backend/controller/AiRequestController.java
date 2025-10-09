package com.ozalp.AI.Generator.Backend.controller;

import com.ozalp.AI.Generator.Backend.business.abstracts.AiRequestService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aiRequest")
@AllArgsConstructor
public class AiRequestController {

    private final AiRequestService aiRequestService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateAiRequest request) {
        return ResponseEntity.ok(aiRequestService.create(request));
    }
}
