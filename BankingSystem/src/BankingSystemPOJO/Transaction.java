package BankingSystemPOJO;

import BankingSystemConstants.CommonConstants;

public class Transaction {
	private int transactionId = CommonConstants.ZERO;
	private int clientId = CommonConstants.ZERO;
	private String accNumber = CommonConstants.EMPTY_STRING;
	private String accType = CommonConstants.EMPTY_STRING;
	private String fromAcc = CommonConstants.EMPTY_STRING;
	private String toAcc = CommonConstants.EMPTY_STRING;
	private Double cheqBalance = 0.0;
	private Double savBalance = 0.0;
	private Double totalBalance = 0.0;
	private Double amount = 0.0;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
	public String getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(String fromAcc) {
		this.fromAcc = fromAcc;
	}
	public String getToAcc() {
		return toAcc;
	}
	public void setToAcc(String toAcc) {
		this.toAcc = toAcc;
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
	public Double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
