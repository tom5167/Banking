package BankingSystemBusinessLogic;

import BankingSystemDAO.LoginDAO;
import BankingSystemPOJO.User;

public class LoginLogic {
	LoginDAO userDAO = new LoginDAO();

	public boolean checkUser(String username, String password, String userType) {
		boolean flag = false;
		User userObj = userDAO.getUserDetails(username, password, userType);
		if (userObj == null) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

	public User getUserDetails(String username, String password, String userType) {
		User userObj = userDAO.getUserDetails(username, password, userType);
		return userObj;
	}
}
