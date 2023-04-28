package com.chenbarry.logindemo.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User{
    private Integer id;

    //@JsonProperty("e_mail") //客製化回傳給前端的欄位名
    private String email;

    private String account;

    @JsonIgnore             //將變數隱藏起來
    private String password;

    private Date CreatedDate;
    private Date lastModifiedDate;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreatedDate() {
        return CreatedDate;
    }
    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    
}