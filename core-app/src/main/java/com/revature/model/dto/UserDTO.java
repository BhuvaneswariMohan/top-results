package com.revature.model.dto;

public class UserDTO {
	private Integer userId;
	private String name;
	private String emailid;
	private String password;
	private String username;

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setTitle(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setId(Object o) {
		if (o != null) {
			this.userId = Integer.parseInt(o.toString());
		}
	}

	public Object getId() {
		return 0;
	}
}
