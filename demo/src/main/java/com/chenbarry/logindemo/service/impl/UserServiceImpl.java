package com.chenbarry.logindemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

import com.chenbarry.logindemo.model.User;
import com.chenbarry.logindemo.request.UserLoginRequest;
import com.chenbarry.logindemo.request.UserRegisterRequest;
import com.chenbarry.logindemo.service.UserService;
import com.chenbarry.logindemo.dao.userDao;

@Component
public class UserServiceImpl implements UserService{
    @Autowired
    private userDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByAccount(userLoginRequest.getAccount());

        //檢查USER是否存在
        if(user == null){
            
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        String hashPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());


        //比對密碼
        if(user.getPassword().equals(hashPassword)){
            return user;
        }else{
            
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {

        //檢查註冊的email
        User userEmail = userDao.getUserByEmail(userRegisterRequest.getEmail());
        if(userEmail != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //檢查註冊的account
        User userAccount = userDao.getUserByAccount(userRegisterRequest.getAccount());
        if(userAccount != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //生成雜湊密碼
        String hashPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashPassword);

        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    
}