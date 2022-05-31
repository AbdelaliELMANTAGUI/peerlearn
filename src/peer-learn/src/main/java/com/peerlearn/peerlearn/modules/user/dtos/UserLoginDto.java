package com.peerlearn.peerlearn.modules.user.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserLoginDto {
    @Email(message = "you must enter a valid email")
    @NotNull(message = "you must provide an email")
    private String email;
    @Length(min = 4,max = 64,message = "password must contain at least 4 characters and not exits 64 characters")
    @NotNull(message = "you must provide a password")
    private String password;

    public UserLoginDto() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
