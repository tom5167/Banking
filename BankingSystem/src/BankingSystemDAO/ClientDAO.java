package BankingSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BankingSystemPOJO.Client;
import BankingSystemUtil.CommonUtil;

public class ClientDAO {
	
	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public boolean insertClientDetails(Client clientDetails) {
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("INSERT INTO tbl_client "
					+ " (client_user_name,client_user_password,client_f_name,client_l_name," 
					+ " client_dob,client_sex,client_address,client_zip_code,"
					+ " client_email,client_phone_no,created_user_id)" 
					+ " VALUES(?,?,?,?,"
					+ " ?,?,?,?,"
					+ " ?,?,?)");
			pstmt.setString(1, clientDetails.getUserName());
			pstmt.setString(2, clientDetails.getPwd());
			pstmt.setString(3, clientDetails.getFirstName());
			pstmt.setString(4, clientDetails.getLastName());
			pstmt.setString(5, clientDetails.getSex());
			pstmt.setString(6, clientDetails.getDob());
			pstmt.setString(7, clientDetails.getAddress());
			pstmt.setString(8, clientDetails.getZip());
			pstmt.setString(9, clientDetails.getEmail());
			pstmt.setString(10, clientDetails.getPhoneNo());
			pstmt.setString(11, commonUtil.getUserId());
			pstmt.execute();
			
			//get client id
			pstmt = conn.prepareStatement("SELECT client_user_id"
					+ " FROM tbl_client"
					+ " WHERE client_user_name=? AND client_user_password=? AND client_f_name=? AND client_l_name=?");
			pstmt.setString(1, clientDetails.getUserName());
			pstmt.setString(2, clientDetails.getPwd());
			pstmt.setString(3, clientDetails.getFirstName());
			pstmt.setString(4, clientDetails.getLastName());
			rs = pstmt.executeQuery();
			int clientId = 0;
			while (rs.next()) {
				clientId = rs.getInt("client_user_id");
			}
			
			for(int i=0;i<Integer.parseInt(clientDetails.getAccNumber());i++) {
				pstmt = conn.prepareStatement("INSERT INTO tbl_account_balance "
						+ " (CLIENT_ID,ACC_NO,C_BALANCE,S_BALANCE)"
						+ " VALUES(?,?,?,?)");
				pstmt.setInt(1, clientId);
				pstmt.setString(2, "BCS"+System.currentTimeMillis());
				pstmt.setDouble(3, 0.0);
				pstmt.setDouble(4, 0.0);
				pstmt.execute();
			}
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
	
	public boolean updateClientDetails(Client clientDetails) {
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("UPDATE tbl_client "
					+ " SET client_user_name=?,client_user_password=?,client_f_name=?,client_l_name=?," 
					+ " client_dob=?,client_sex=?,client_address=?,client_zip_code=?,"
					+ " client_email=?,client_phone_no=?" 
					+ " WHERE client_user_id=?");
			pstmt.setString(1, clientDetails.getUserName());
			pstmt.setString(2, clientDetails.getPwd());
			pstmt.setString(3, clientDetails.getFirstName());
			pstmt.setString(4, clientDetails.getLastName());
			pstmt.setString(5, clientDetails.getSex());
			pstmt.setString(6, clientDetails.getDob());
			pstmt.setString(7, clientDetails.getAddress());
			pstmt.setString(8, clientDetails.getZip());
			pstmt.setString(9, clientDetails.getEmail());
			pstmt.setString(10, clientDetails.getPhoneNo());
			pstmt.setInt(11, clientDetails.getClientId());
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
	
	public boolean deleteClientDetails(Client clientDetails) {
		boolean flag = true;
		try {
			conn = DBConn.jdbcConnection();
			pstmt = conn.prepareStatement("DELETE FROM tbl_client"
					+ " WHERE client_user_id = ?");
			pstmt.setInt(1, clientDetails.getClientId());
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
	
	public List<Client> getAlClientDetails(String firstName) {
		List<Client> clientDetails = new ArrayList<Client>();
		try {
			conn = DBConn.jdbcConnection();
			String sql = "SELECT client_user_id,client_user_name,client_user_password,client_f_name,client_l_name," 
					+ " client_dob,client_sex,client_address,client_zip_code,"
					+ " client_email,client_phone_no"
					+ " FROM tbl_client"
					+ " WHERE client_f_name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + firstName + "%");
			rs = pstmt.executeQuery();
			Client clientObj = null;
			while (rs.next()) {
				clientObj = new Client();
				clientObj.setClientId(rs.getInt("client_user_id"));
				clientObj.setUserName(rs.getString("client_user_name"));
				clientObj.setPwd(rs.getString("client_user_password"));
				clientObj.setFirstName(rs.getString("client_f_name"));
				clientObj.setLastName(rs.getString("client_l_name"));
				clientObj.setSex(rs.getString("client_dob"));
				clientObj.setDob(rs.getString("client_sex"));
				clientObj.setAddress(rs.getString("client_address"));
				clientObj.setZip(rs.getString("client_zip_code"));
				clientObj.setEmail(rs.getString("client_email"));
				clientObj.setPhoneNo(rs.getString("client_phone_no"));
				clientDetails.add(clientObj);
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
		return clientDetails;
	}
}
