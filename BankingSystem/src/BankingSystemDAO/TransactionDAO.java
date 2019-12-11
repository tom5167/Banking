package BankingSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BankingSystemPOJO.Transaction;
import BankingSystemUtil.CommonUtil;


public class TransactionDAO {
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public boolean withdrawAmount(Transaction transDetails) {
		boolean flag = true;
		boolean transflag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tbl_account_balance "
					+ " SET C_BALANCE=?,S_BALANCE=?" 
					+ " WHERE CLIENT_ID=? AND ACC_NO=?");
			if(transDetails.getAccType().equalsIgnoreCase("Chequing")) {
				pstmt.setDouble(1, transDetails.getCheqBalance()-transDetails.getAmount());
				pstmt.setDouble(2, transDetails.getSavBalance());
			} else if (transDetails.getAccType().equalsIgnoreCase("Saving")) {
				pstmt.setDouble(1, transDetails.getCheqBalance());
				pstmt.setDouble(2, transDetails.getSavBalance()-transDetails.getAmount());
			}
			pstmt.setInt(3, Integer.parseInt(commonUtil.getUserId()));
			pstmt.setString(4, transDetails.getAccNumber());
			pstmt.execute();
			transflag = insertTransactionDetails(transDetails,true,false,true);
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag && transflag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag && transflag;
			}
		}
		return flag && transflag;
	}

	public boolean depositAmount(Transaction transDetails) {
		boolean flag = true;
		boolean transflag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tbl_account_balance "
					+ " SET C_BALANCE=?,S_BALANCE=?" 
					+ " WHERE CLIENT_ID=? AND ACC_NO=?");
			if(transDetails.getAccType().equalsIgnoreCase("Chequing")) {
				pstmt.setDouble(1, transDetails.getCheqBalance()+transDetails.getAmount());
				pstmt.setDouble(2, transDetails.getSavBalance());
			} else if (transDetails.getAccType().equalsIgnoreCase("Saving")) {
				pstmt.setDouble(1, transDetails.getCheqBalance());
				pstmt.setDouble(2, transDetails.getSavBalance()+transDetails.getAmount());
			}
			pstmt.setInt(3, Integer.parseInt(commonUtil.getUserId()));
			pstmt.setString(4, transDetails.getAccNumber());
			pstmt.execute();
			transflag = insertTransactionDetails(transDetails,false,true,false);
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag && transflag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag && transflag;
			}
		}
		return flag && transflag;
	}

	public boolean transferAmount(Transaction transDetails) {
		boolean flag = true;
		boolean transflag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tbl_account_balance "
					+ " SET C_BALANCE=?,S_BALANCE=?" 
					+ " WHERE CLIENT_ID=? AND ACC_NO=?");
			if(transDetails.getFromAcc().equalsIgnoreCase("Chequing")) {
				pstmt.setDouble(1, transDetails.getCheqBalance()-transDetails.getAmount());
				pstmt.setDouble(2, transDetails.getSavBalance()+transDetails.getAmount());
			} else if (transDetails.getFromAcc().equalsIgnoreCase("Saving")) {
				pstmt.setDouble(1, transDetails.getCheqBalance()+transDetails.getAmount());
				pstmt.setDouble(2, transDetails.getSavBalance()-transDetails.getAmount());
			}
			pstmt.setInt(3, Integer.parseInt(commonUtil.getUserId()));
			pstmt.setString(4, transDetails.getAccNumber());
			pstmt.execute();
			transflag = insertTransactionDetails(transDetails,false,false,true);
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag && transflag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag && transflag;
			}
		}
		return flag && transflag;
	}
	
	public boolean insertTransactionDetails(Transaction transDetails,boolean is_debit,boolean is_credit,boolean is_transfer) {
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tbl_transaction "
					+ " (client_id,acc_no,amount,"
					+ " is_debit,is_credit,is_transfer)" 
					+ " VALUES(?,?,?,"
					+ " ?,?,?)");
			pstmt.setInt(1, Integer.parseInt(commonUtil.getUserId()));
			pstmt.setString(2, transDetails.getAccNumber());
			pstmt.setDouble(3, transDetails.getAmount());
			if(is_debit) {
				pstmt.setString(4, "Yes");
				pstmt.setString(5, "No");
				pstmt.setString(6, "No");
			} else if (is_credit) {
				pstmt.setString(4, "No");
				pstmt.setString(5, "Yes");
				pstmt.setString(6, "No");
			} else if (is_transfer) {
				pstmt.setString(4, "No");
				pstmt.setString(5, "No");
				pstmt.setString(6, "Yes");
			} else {
				pstmt.setString(4, "No");
				pstmt.setString(5, "No");
				pstmt.setString(6, "No");
			}
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag;
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		return flag;
	}
	
	public List<Transaction> getAlAccDetails() {
		List<Transaction> transDetails = new ArrayList<Transaction>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT ACC_NO"
					+ " FROM tbl_account_balance"
					+ " WHERE CLIENT_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commonUtil.getUserId());
			rs = pstmt.executeQuery();
			Transaction transObj = null;
			while (rs.next()) {
				transObj = new Transaction();
				transObj.setAccNumber(rs.getString("ACC_NO"));
				transDetails.add(transObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return transDetails;
	}
	
	public Transaction getAccDetails(String accNumber) {
		Transaction transObj = null;
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT ACC_NO,C_BALANCE,S_BALANCE"
					+ " FROM tbl_account_balance"
					+ " WHERE CLIENT_ID=? AND ACC_NO=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commonUtil.getUserId());
			pstmt.setString(2, accNumber);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				transObj = new Transaction();
				transObj.setAccNumber(rs.getString("ACC_NO"));
				transObj.setCheqBalance(rs.getDouble("C_BALANCE"));
				transObj.setSavBalance(rs.getDouble("S_BALANCE"));
				transObj.setTotalBalance(rs.getDouble("S_BALANCE")+rs.getDouble("C_BALANCE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return transObj;
	}
	
}
