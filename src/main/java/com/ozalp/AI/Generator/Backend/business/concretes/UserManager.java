package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.RoleService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserMapper;
import com.ozalp.AI.Generator.Backend.business.rules.UserRules;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.dataAccess.UserRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.Role;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final UserRules rules;
    private final RoleService roleService;

    @Transactional
    @Override
    public User create(User user) {
        rules.checkEmail(user);
        rules.checkUserName(user);
        user.setRoles(setUserForInitRole(user));
        return repository.save(user);
    }

    @Override
    public Result delete(UUID id) {
        User dbUser = getById(id);
        dbUser.markAsDeleted();
        repository.save(dbUser);
        return new Result(true);
    }

    @Override
    public User getById(UUID id) {
        return repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(Messages.User_NOT_FOUND));
    }

//    @Override
//    public User save(User entity) {
//        return repository.save(entity);
//    }

    private List<UserRole> setUserForInitRole(User user) {
        Role role = roleService.getByName(RoleType.ROLE_USER);
        if (role == null) {
            Role newRole = new Role();
            newRole.setName(RoleType.ROLE_USER);
            role = roleService.create(newRole);
        }
        UserRole userRole = new UserRole(user, role);
        return List.of(userRole);
    }

}
