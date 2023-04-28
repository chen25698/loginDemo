package com.chenbarry.logindemo.dao.daoImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.chenbarry.logindemo.UserRowMapper;
import com.chenbarry.logindemo.dao.userDao;
import com.chenbarry.logindemo.model.User;
import com.chenbarry.logindemo.request.UserRegisterRequest;

@Component
public class userDaoImpl  implements userDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Override
    public Integer createUser(UserRegisterRequest userRegisterRequest) {
        String sql = "INSERT INTO logindemo(account, email, password, created_date, last_modified_date) " +
                    "VALUES (:account, :email, :password, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("account", userRegisterRequest.getAccount());
        map.put("email", userRegisterRequest.getEmail());
        map.put("password", userRegisterRequest.getPassword());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map),keyHolder);

        int userId = keyHolder.getKey().intValue();
        
        return userId;
    }

    @Override
    public User getUserByAccount(String account) {
        String sql = "SELECT id, account, email, password, created_date, last_modified_date " + 
        "FROM users WHERE account = :account";

        Map<String, Object> map = new HashMap<>();
        map.put("account", account);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(userList.size() > 0){
            return userList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT id, account, email, password, created_date, last_modified_date " + 
        "FROM users WHERE email = :email";

        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(userList.size() > 0){
            return userList.get(0);
        }else{
            return null;
        }
    }

    @Override
    public User getUserById(Integer userId) {
        String sql = "SELECT id, email, password, created_date,last_modified_date "+
        "FROM logindemo WHERE id = :userId";

        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if(userList.size() > 0){
            return userList.get(0);
        }else{
            return null;
        }
    }
    
}
