package com.ozalp.AI.Generator.Backend.controller;

import com.ozalp.AI.Generator.Backend.business.abstracts.AiToolService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateAiToolRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/aiTool")
public class AiToolController {

    private final AiToolService aiToolService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateAiToolRequest request) {
        return ResponseEntity.ok(aiToolService.create(request));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam UUID uuid) {
        return ResponseEntity.ok(aiToolService.delete(uuid));
    }

}
