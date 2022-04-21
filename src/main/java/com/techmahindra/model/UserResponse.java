package com.techmahindra.model;

public class UserResponse {
	
	public UserResponse() {
		
	}
	public UserResponse(String token, String note) {
		this.token = token;
		this.note = note;
	}
	
	private String token;
	
	private String note;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
