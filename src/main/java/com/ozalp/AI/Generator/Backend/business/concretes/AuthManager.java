package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AuthService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserRoleService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.UserLoginByEmailRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AuthUserResponse;
import com.ozalp.AI.Generator.Backend.business.mappers.UserMapper;
import com.ozalp.AI.Generator.Backend.common.security.jwt.JwtService;
import com.ozalp.AI.Generator.Backend.common.utilities.constants.Messages;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.common.utilities.results.SuccessDataResult;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import com.ozalp.AI.Generator.Backend.entities.concretes.UserRole;
import com.ozalp.AI.Generator.Backend.exceptions.errors.BusinessException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;

    @Transactional
    @Override
    public DataResult<AuthUserResponse> register(CreateUserRequest request) {
        User reqUser = userMapper.toEntity(request);
        User dbUser = userService.create(reqUser);
        return generateTokens(dbUser);
    }

    @Override
    public DataResult<AuthUserResponse> login(UserLoginByEmailRequest request) {
        User user = userService.getByEmail(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException(Messages.USER_INFORMATION_DOES_NOT_MATCH);
        }
        return generateTokens(user);
    }

    public DataResult<AuthUserResponse> generateTokens(User user) {
        String generatedToken = jwtService.generateToken(user.getEmail(), userService.getRoleListOfUser(user.getId()));
        String refreshToken = jwtService.generateRefreshToken(user.getEmail());

        AuthUserResponse authUserResponse = new AuthUserResponse();
        authUserResponse.setUser(userMapper.toResponse(user));
        authUserResponse.setToken(generatedToken);
        authUserResponse.setRefreshToken(refreshToken);
        return new SuccessDataResult<>(authUserResponse);
    }

}