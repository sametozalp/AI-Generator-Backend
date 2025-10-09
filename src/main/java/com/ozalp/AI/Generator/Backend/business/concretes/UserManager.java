package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.RoleService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserRoleService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.UserLoginByEmailRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserMapper;
import com.ozalp.AI.Generator.Backend.business.rules.UserRules;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.Result;
import com.ozalp.AI.Generator.Backend.dataAccess.UserRepository;
import com.ozalp.AI.Generator.Backend.entities.concretes.Role;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import com.ozalp.AI.Generator.Backend.exceptions.errors.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository repository;
    private final UserRules rules;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;
    private final UserRoleService userRoleService;

    @Override
    public User create(User user) {
        rules.checkEmail(user);
        rules.checkUserName(user);
        setUserForInitRole();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User dbUser = repository.save(user);
        userRoleService.create(new UserRole(dbUser, roleService.getByName(RoleType.ROLE_USER)));
        return getById(dbUser.getId());
    }

    @Override
    public UserResponse login(UserLoginByEmailRequest request) {
        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());
        rules.checkMatchesPassword(email, password);
        User dbUser = getByEmail(email);
        return mapper.toResponse(dbUser);
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
        User user = repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException(Messages.USER_NOT_FOUND));

        List<UserRole> userRoles = userRoleService.getAllByUser(user);
        user.setRoles(userRoles);
        return user;
    }

    @Override
    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(()
                -> new EntityNotFoundException(Messages.USER_NOT_FOUND));
    }

    @Override
    public List<String> getRoleListOfUser(UUID id) {
        User user = getById(id);
        return user.getAuthorities() != null
                ? user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList()
                : List.of();
    }

    private void setUserForInitRole() {
        Role role = roleService.getByName(RoleType.ROLE_USER);
        if (role == null) {
            Role newRole = new Role();
            newRole.setName(RoleType.ROLE_USER);
            roleService.create(newRole);
        }
    }
}
