package com.ibm.projectManagerBasic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userPhoneNum")
	private String userPhoneNum;
	
	@Column(name = "userDesignation")
	private String userDesignation;
	
	@Column(name = "userPassword")
	private String userPassword;

	public String getUserName() {
		return userName;
	}

	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public String getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(String userDesignation) {
		this.userDesignation = userDesignation;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
