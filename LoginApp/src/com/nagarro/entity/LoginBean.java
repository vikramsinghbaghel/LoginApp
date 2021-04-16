package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serialNo;

	private String userName;
	private String password;

//	
//	@OneToMany (mappedBy="loginbean")
//	private List<UserImages> myImage =new ArrayList<>();
//	
	public LoginBean() {
		super();

	}

	public LoginBean(int serialNo, String username, String password) {
		super();
		this.serialNo = serialNo;
		this.userName = username;
		this.password = password;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [serialNo=" + serialNo + ", username=" + userName + ", password=" + password + "]";
	}

}
