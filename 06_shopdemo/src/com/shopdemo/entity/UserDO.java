package com.shopdemo.entity;

public class UserDO {

	private String account;
	private String password;
	private long loginTime;
	
	public UserDO() {
		super();
	}
	
	public UserDO(String account, String password, long loginTime) {
		super();
		this.account = account;
		this.password = password;
		this.loginTime = loginTime;
	}
	
	public String getAccount() {
		return account;
	}
	
	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getLoginTime() {
		return loginTime;
	}
	
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	@Override
	public String toString() {
		return "UserDO [account=" + account + ", password=" + password + ", loginTime=" + loginTime + "]";
	}
	
	
}
