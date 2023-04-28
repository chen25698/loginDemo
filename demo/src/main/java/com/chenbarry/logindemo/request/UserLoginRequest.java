package com.chenbarry.logindemo.request;

import jakarta.validation.constraints.NotBlank;

public class UserLoginRequest {

    @NotBlank
    private String account;
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
