package com.chenbarry.logindemo.dao;

import com.chenbarry.logindemo.model.User;
import com.chenbarry.logindemo.request.UserRegisterRequest;

public interface userDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);

    User getUserByAccount(String account);
}
