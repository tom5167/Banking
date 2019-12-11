package BankingSystemPOJO;

import BankingSystemConstants.CommonConstants;

public class Bill {
	
	private int billId = CommonConstants.ZERO;
	private int clientId = CommonConstants.ZERO;
	private String accNumber = CommonConstants.EMPTY_STRING;
	private String accType = CommonConstants.EMPTY_STRING;
	private String billType = CommonConstants.EMPTY_STRING;
	private Double billAmount = 0.0;
	private String isPayed = CommonConstants.EMPTY_STRING;
	private Double cheqBalance = 0.0;
	private Double savBalance = 0.0;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public Double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}
	public String getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(String isPayed) {
		this.isPayed = isPayed;
	}
	public Double getCheqBalance() {
		return cheqBalance;
	}
	public void setCheqBalance(Double cheqBalance) {
		this.cheqBalance = cheqBalance;
	}
	public Double getSavBalance() {
		return savBalance;
	}
	public void setSavBalance(Double savBalance) {
		this.savBalance = savBalance;
	}	
}
