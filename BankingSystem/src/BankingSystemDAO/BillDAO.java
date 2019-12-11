package BankingSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BankingSystemPOJO.Bill;
import BankingSystemUtil.CommonUtil;

public class BillDAO {
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean updateBillDetails(Bill billDetails) {
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tbl_bill "
					+ " SET is_payed= ?" 
					+ " WHERE bill_id = ?");
			pstmt.setString(1, "Yes");
			pstmt.setInt(2, billDetails.getBillId());
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
			flag =  false;
			return flag;
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				flag =  false;
				return flag;
			}
		}
		return flag;
	}
	
	public List<Bill> getAlBillDetails() {
		List<Bill> billDetails = new ArrayList<Bill>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT bill_id,client_id,bill_type,bill_amount,is_payed"
					+ " FROM tbl_bill"
					+ " WHERE client_id=? AND is_payed='No'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commonUtil.getUserId());
			rs = pstmt.executeQuery();
			Bill billObj = null;
			while (rs.next()) {
				billObj = new Bill();
				billObj.setBillId(rs.getInt("bill_id"));
				billObj.setClientId(rs.getInt("client_id"));
				billObj.setBillType(rs.getString("bill_type"));
				billObj.setBillAmount(rs.getDouble("bill_amount"));
				billObj.setIsPayed(rs.getString("is_payed"));
				billDetails.add(billObj);
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
		return billDetails;
	}
}
