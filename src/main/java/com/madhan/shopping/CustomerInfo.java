package com.madhan.shopping;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CustomerInfo {
    // Validation Annotations

    // Won't allow empty spaces as vaid
    @NotBlank
    @Length(min = 3, max = 10)
    private String name;

    // Allows space as valid character
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
