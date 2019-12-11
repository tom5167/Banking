package BankingSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BankingSystemPOJO.User;
import BankingSystemUtil.CommonUtil;

public class LoginDAO {

	CommonUtil commonUtil = new CommonUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public User getUserDetails(String username, String pwd, String type) {

		User userObj = null;
		try {
			if (type.equalsIgnoreCase("ADMIN")) {
				userObj = new User();
				userObj.setUserId(0);
				userObj.setUserName("admin");
				userObj.setPwd("admin");
				userObj.setUserType(type);
			} else if (type.equalsIgnoreCase("CLIENT")) {
				conn = DBConn.jdbcConnection();
				String sql = "SELECT client_user_id,client_user_name,client_user_password"
						+ " FROM tbl_client" 
						+ " WHERE client_user_name=? AND client_user_password=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					userObj = new User();
					userObj.setUserId(rs.getInt("client_user_id"));
					userObj.setUserName(rs.getString("client_user_name"));
					userObj.setPwd(rs.getString("client_user_password"));
					userObj.setUserType(type);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userObj;
	}

}
