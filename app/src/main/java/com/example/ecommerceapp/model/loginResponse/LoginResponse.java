package com.example.ecommerceapp.model.loginResponse;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("code")
	private int code;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}