package BankingSystemPOJO;

import BankingSystemConstants.CommonConstants;

public class Client {
	
	private int clientId = CommonConstants.ZERO;
	private String userType = CommonConstants.EMPTY_STRING;
	private String userName = CommonConstants.EMPTY_STRING;
	private String pwd = CommonConstants.EMPTY_STRING;
	private String firstName = CommonConstants.EMPTY_STRING;
	private String lastName = CommonConstants.EMPTY_STRING;
	private String sex = CommonConstants.EMPTY_STRING;
	private String dob = CommonConstants.EMPTY_STRING;
	private String address = CommonConstants.EMPTY_STRING;
	private String zip = CommonConstants.EMPTY_STRING;
	private String email = CommonConstants.EMPTY_STRING;
	private String phoneNo = CommonConstants.EMPTY_STRING;
	private String accNumber = CommonConstants.EMPTY_STRING;
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
}
