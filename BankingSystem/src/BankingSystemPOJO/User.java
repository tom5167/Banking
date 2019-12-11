package BankingSystemPOJO;

import BankingSystemConstants.CommonConstants;

public class User {
	
	private int userId = CommonConstants.ZERO;
	private String userName = CommonConstants.EMPTY_STRING;
	private String pwd = CommonConstants.EMPTY_STRING;
	private String userType = CommonConstants.EMPTY_STRING;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}
