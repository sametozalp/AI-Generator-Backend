package com.ozalp.AI.Generator.Backend.business.concretes;

import com.ozalp.AI.Generator.Backend.business.abstracts.AuthService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserDetailService;
import com.ozalp.AI.Generator.Backend.business.abstracts.UserService;
import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.CreateUserRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.AuthUserResponse;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserDetailResponse;
import com.ozalp.AI.Generator.Backend.common.utilities.results.DataResult;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthManager implements AuthService {

    private final UserService userService;
    private final UserDetailService userDetailService;

    @Override
    public void register(CreateUserRequest request) {

    }

    public DataResult<AuthUserResponse> generateTokens(User user) {

//        DataResult<AuthUserResponse> response = userService.getUserDetails(user.getId());
//
//        String generatedToken = jwtService.generateToken(user.getEmail(),
//                user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
//
//        String refreshToken = jwtService.generateRefreshToken(user.getEmail());
//
//        UserDetailResponse userDetailResponse = response.getData().getUser();
//        userDetailResponse.setAccessToken(generatedToken);
//        userDetailResponse.setRefreshToken(refreshToken);
//
//        response.getData().setUser(userDetailResponse);

        return response;
    }
}
