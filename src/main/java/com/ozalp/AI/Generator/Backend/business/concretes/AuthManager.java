package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AuthService;
import com.ozalp.AI.Generator.Backend.business.abstracts.RoleService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserDetailService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AuthUserResponse;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.RoleResponse;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserRoleResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.RoleMapper;
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

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    @Transactional
    @Override
    public DataResult<AuthUserResponse> register(CreateUserRequest request) {
        User reqUser = userMapper.toEntity(request);

        String generatedToken = jwtService.generateToken(reqUser.getEmail(),
                reqUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
        String refreshToken = jwtService.generateRefreshToken(reqUser.getEmail());
        User dbUser = userService.create(reqUser);

        AuthUserResponse authUserResponse = new AuthUserResponse();
        authUserResponse.setUser(userMapper.toResponse(dbUser));
        authUserResponse.setToken(generatedToken);
        authUserResponse.setRefreshToken(refreshToken);
        return new SuccessDataResult<>(authUserResponse);
    }

}
