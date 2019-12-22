package com.miw.model;

public class UserInfo {
	
	private String username = null;
	private String email = null;
	private String password = null;
	
	public UserInfo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

}
