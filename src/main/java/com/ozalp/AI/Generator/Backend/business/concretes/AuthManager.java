package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.*;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AuthUserResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserMapper;
import com.ozalp.AI.Generator.Backend.common.security.jwt.JwtService;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.entities.concretes.Role;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import com.ozalp.AI.Generator.Backend.enums.RoleType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;
    private final UserDetailService userDetailService;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserRoleService userRoleService;

    @Transactional
    @Override
    public DataResult<AuthUserResponse> register(CreateUserRequest request) {
        User reqUser = userMapper.toEntity(request);
        reqUser.setRoles(setUserForInitRole(reqUser));
        User dbUser = userService.save(reqUser);
        String generatedToken = jwtService.generateToken(dbUser.getEmail(),
                dbUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
        String refreshToken = jwtService.generateRefreshToken(dbUser.getEmail());

        AuthUserResponse authUserResponse = new AuthUserResponse();
        authUserResponse.setUser(userMapper.toResponse(dbUser));
        authUserResponse.setToken(generatedToken);
        authUserResponse.setRefreshToken(refreshToken);
        return new SuccessDataResult<>(authUserResponse);
    }

    @Transactional
    private List<UserRole> setUserForInitRole(User user) {
        Role role = roleService.getByName(RoleType.USER);
        if (role == null) {
            Role newRole = new Role();
            newRole.setName(RoleType.USER);
            role = roleService.save(newRole);
        }
        UserRole userRole = new UserRole(user, role);
        return List.of(userRole);
    }

}
