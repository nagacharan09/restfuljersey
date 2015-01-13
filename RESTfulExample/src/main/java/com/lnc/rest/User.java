package com.lnc.rest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String userName;
	private String userPasswd;

	public User(String userName, String userPasswd) {
		this.userName = userName;
		this.userPasswd = userPasswd;
	}

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	@XmlElement
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
}
