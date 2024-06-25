package com.example.ecommerceapp.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("id")
	private String id;
	@SerializedName("username")
	private String username;
	@SerializedName("email")
    private String email;
	@SerializedName("password")
	private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}