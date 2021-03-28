package com.ibm.projectManagerBasic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails {
	
	@Id
	@SequenceGenerator(name="user_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "user_sequence")
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userEmailId")
	private String userEmailId;
	
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

	public String getUserEmailId() {
		return userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
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
