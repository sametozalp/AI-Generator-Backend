package com.ozalp.AI.Generator.Backend.business.abstracts;

import com.ozalp.AI.Generator.Backend.business.dtos.requests.concretes.UserLoginByEmailRequest;
import com.ozalp.AI.Generator.Backend.business.dtos.responses.concretes.UserResponse;
import com.ozalp.AI.Generator.Backend.entities.concretes.User;

import java.util.List;
import java.util.UUID;

public interface UserService extends BaseService<User> {

    User create(User user);

    UserResponse login(UserLoginByEmailRequest request);

    User getByEmail(String email);

    List<String> getRoleListOfUser(UUID id);

}
