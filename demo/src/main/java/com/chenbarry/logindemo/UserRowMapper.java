package com.chenbarry.logindemo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chenbarry.logindemo.model.User;

public class UserRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setAccount(resultSet.getString("account"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setCreatedDate(resultSet.getTimestamp("created_date"));
        user.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return user;
    }
    
}
