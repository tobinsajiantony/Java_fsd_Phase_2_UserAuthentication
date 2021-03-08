package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class EUser {
	 @Id @Column(name="Id")
	 @GeneratedValue
	private int Id;
	 @Column(name="UserName")
	private String UserName;
	 @Column(name="Password")
	private String Password;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
