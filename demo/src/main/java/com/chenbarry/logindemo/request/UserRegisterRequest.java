package com.chenbarry.logindemo.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterRequest {
    @NotBlank
    @Email
    String email;

    @NotBlank
    String account;

    @NotBlank
    String password;

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

    
}
