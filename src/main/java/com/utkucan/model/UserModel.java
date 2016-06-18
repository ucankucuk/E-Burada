package com.utkucan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer USER_ID;

	@Column(name = "USER_NAME")
	private String USER_NAME;

	@Column(name = "USER_SURNAME")

	private String USER_SURNAME;

	@Column(name = "USER_EMAIL")
	private String USER_EMAIL;

	@Column(name = "USER_PASS")
	private String USER_PASS;

	@Column(name = "USER_ADDRESS")
	private String USER_ADDRESS;

	@Column(name = "USER_OTHER_ADDRESS")
	private String USER_OTHER_ADDRESS;

	@Column(name = "USER_MOBILE")
	private String USER_MOBILE;

	@Column(name = "USER_OTHER_MOBILE")
	private String USER_OTHER_MOBILE;

	@Column(name = "AUTORIZATION_ID")
	private Integer AUTORIZATION_ID;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "USER_ID", cascade = CascadeType.ALL)
	private List<OrderModel> Orders;

	public Integer getAUTORIZATION_ID() {
		return AUTORIZATION_ID;
	}

	public void setAUTORIZATION_ID(Integer aUTORIZATION_ID) {
		AUTORIZATION_ID = aUTORIZATION_ID;
	}

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_SURNAME() {
		return USER_SURNAME;
	}

	public void setUSER_SURNAME(String uSER_SURNAME) {
		USER_SURNAME = uSER_SURNAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public String getUSER_PASS() {
		return USER_PASS;
	}

	public void setUSER_PASS(String uSER_PASS) {
		USER_PASS = uSER_PASS;
	}

	public String getUSER_ADDRESS() {
		return USER_ADDRESS;
	}

	public void setUSER_ADDRESS(String uSER_ADDRESS) {
		USER_ADDRESS = uSER_ADDRESS;
	}

	public String getUSER_OTHER_ADDRESS() {
		return USER_OTHER_ADDRESS;
	}

	public void setUSER_OTHER_ADDRESS(String uSER_OTHER_ADDRESS) {
		USER_OTHER_ADDRESS = uSER_OTHER_ADDRESS;
	}

	public String getUSER_MOBILE() {
		return USER_MOBILE;
	}

	public void setUSER_MOBILE(String uSER_MOBILE) {
		USER_MOBILE = uSER_MOBILE;
	}

	public String getUSER_OTHER_MOBILE() {
		return USER_OTHER_MOBILE;
	}

	public void setUSER_OTHER_MOBILE(String uSER_OTHER_MOBILE) {
		USER_OTHER_MOBILE = uSER_OTHER_MOBILE;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String uSER_NAME, String uSER_SURNAME, String uSER_EMAIL, String uSER_PASS) {
		super();
		USER_NAME = uSER_NAME;
		USER_SURNAME = uSER_SURNAME;
		USER_EMAIL = uSER_EMAIL;
		USER_PASS = uSER_PASS;
		AUTORIZATION_ID = 0;
	}

	public UserModel(Integer uSER_ID, String uSER_NAME, String uSER_SURNAME, String uSER_EMAIL, String uSER_PASS,
			String uSER_ADDRESS, String uSER_OTHER_ADDRESS, String uSER_MOBILE, String uSER_OTHER_MOBILE,
			Integer aUTORIZATION_ID) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_SURNAME = uSER_SURNAME;
		USER_EMAIL = uSER_EMAIL;
		USER_PASS = uSER_PASS;
		USER_ADDRESS = uSER_ADDRESS;
		USER_OTHER_ADDRESS = uSER_OTHER_ADDRESS;
		USER_MOBILE = uSER_MOBILE;
		USER_OTHER_MOBILE = uSER_OTHER_MOBILE;
		AUTORIZATION_ID = aUTORIZATION_ID;
	}

	public UserModel(int parseInt) {
		this.USER_ID = parseInt;
	}

}
