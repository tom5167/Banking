package BankingSystemBusinessLogic;

import java.util.List;

import BankingSystemDAO.BillDAO;
import BankingSystemDAO.TransactionDAO;
import BankingSystemPOJO.Bill;
import BankingSystemPOJO.Transaction;

public class ClientLogic {
	
	TransactionDAO transDAO = new TransactionDAO();
	BillDAO billDAO = new BillDAO();

	public boolean withdrawAmount(Transaction transDetails) {
		return transDAO.withdrawAmount(transDetails);
	}

	public boolean depositAmount(Transaction transDetails) {
		return transDAO.depositAmount(transDetails);
	}

	public boolean transferAmount(Transaction transDetails) {
		return transDAO.transferAmount(transDetails);
	}
	
	public List<Transaction> getAlAccDetails() {
		return transDAO.getAlAccDetails();
	}
	
	public Transaction getAccDetails(String accNumber) {
		return transDAO.getAccDetails(accNumber);
	}
	
	public List<Bill> getAlBillDetails(){
		return billDAO.getAlBillDetails();
	}
	
	public boolean updateBillDetails(Bill billDetails) {
		Transaction transObj = new Transaction();
		transObj.setAccNumber(billDetails.getAccNumber());
		transObj.setAccType(billDetails.getAccType());
		transObj.setAmount(billDetails.getBillAmount());
		transObj.setCheqBalance(billDetails.getCheqBalance());
		transObj.setSavBalance(billDetails.getSavBalance());
		boolean flag = transDAO.withdrawAmount(transObj);
		return flag && billDAO.updateBillDetails(billDetails);
	}
}
