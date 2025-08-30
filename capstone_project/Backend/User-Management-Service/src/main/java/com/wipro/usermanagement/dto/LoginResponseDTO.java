package com.wipro.usermanagement.dto;

public class LoginResponseDTO 
{
    private String message;
    private String token;
    
	public LoginResponseDTO(String message, String token) {
		super();
		this.message = message;
		this.token = token;
	}
	
	public LoginResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	} 
}
