package com.spring.dto;

import java.util.Date;

public class UserDto {
    private String username;
    private String fullname;
    private String password;
    private String email;
    private String status;
    private String role;
    private String func;
    private Date last_login;
    private String phone_number;
    private Date created_on;
    private Date modified_on;
    private String created_by;
    private String modified_by;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }


    @Override
	public String toString() {
		return "UserDto [username=" + username + ", fullname=" + fullname + ", password="
				+ password + ", email=" + email + ", status=" + status + ", role=" + role + ", func=" + func
				+ ", last_login=" + last_login + ", phone_number=" + phone_number + ", created_on=" + created_on
				+ ", modified_on=" + modified_on + ", created_by=" + created_by + ", modified_by=" + modified_by + "]";
	}

	public UserDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }

    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modified_on) {
        this.modified_on = modified_on;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

}
