package com.chenbarry.logindemo.service;

import com.chenbarry.logindemo.model.User;
import com.chenbarry.logindemo.request.UserLoginRequest;
import com.chenbarry.logindemo.request.UserRegisterRequest;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
