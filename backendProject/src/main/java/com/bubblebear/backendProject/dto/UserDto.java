package com.bubblebear.backendProject.dto;

import java.util.Date;

public class UserDto {
	
	
	private String fullname; 
	
	private String email; 
	
	private String password; 
	
	private Date birthday; 
	
	private String phone_number; 
	
	private Boolean role; 
	
	
	public UserDto (String fullname, String email, String password, 
			Date birthday, String phone_number, Boolean role) {
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.phone_number = phone_number;
		this.role = role;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public Boolean getRole() {
		return role;
	}


	public void setRole(Boolean role) {
		this.role = role;
	}
	
	
}
