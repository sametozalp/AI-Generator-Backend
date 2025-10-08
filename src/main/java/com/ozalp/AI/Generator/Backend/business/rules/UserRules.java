package com.ozalp.AI.Generator.Backend.business.rules;

import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.dataAccess.UserRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.exceptions.errors.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRules {

    private final UserRepository repository;

    public void checkUserName(User user) {
        if(repository.existsByUsername(user.getUsername())) {
            throw new BusinessException(Messages.USERNAME_ALREADY_EXISTS);
        }
    }

    public void checkEmail(User user) {
        if(repository.existsByEmail(user.getEmail())) {
            throw new BusinessException(Messages.EMAIL_ALREADY_EXISTS);
        }
    }
}
