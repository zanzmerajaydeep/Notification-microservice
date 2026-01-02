package com.notifier.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("smsadmin")
public class SMSAdmin {
	private String account_sid;
	private String auth_token;
	private String phoneNo;
	
	
	@Override
	public String toString() {
		return "SMSAdmin [account_sid=" + account_sid + ", auth_token=" + auth_token + ", phoneNo=" + phoneNo + "]";
	}


	public SMSAdmin(String account_sid, String auth_token, String phoneNo) {
		super();
		this.account_sid = account_sid;
		this.auth_token = auth_token;
		this.phoneNo = phoneNo;
	}


	public String getAccount_sid() {
		return account_sid;
	}


	public void setAccount_sid(String account_sid) {
		this.account_sid = account_sid;
	}


	public String getAuth_token() {
		return auth_token;
	}


	public void setAuth_token(String auth_token) {
		this.auth_token = auth_token;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public SMSAdmin() {
		super();
	}
	
}
