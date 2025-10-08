package com.ozalp.AI.Generator.Backend.business.rules;

import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.dataAccess.AiToolRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.AiTool;
import com.ozalp.AI.Generator.Backend.exceptions.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AiToolRules {

    private final AiToolRepository repository;

    public void checkIfToolNameExists(AiTool aiTool) {

        if (repository.existsByName(aiTool.getName())) {
            throw new BusinessException(Messages.AI_TOOL_ALREADY_EXISTS);
        }
    }

}
