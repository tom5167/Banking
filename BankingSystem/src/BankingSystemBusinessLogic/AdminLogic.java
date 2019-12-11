package BankingSystemBusinessLogic;

import java.util.List;

import BankingSystemDAO.ClientDAO;
import BankingSystemPOJO.Client;

public class AdminLogic {
	
	ClientDAO clientDAO = new ClientDAO();

	public List<Client> getAlClientDetails(String firstName) {
		return clientDAO.getAlClientDetails(firstName);
	}
	
	public boolean saveClientDetails(Client patientDetails) {
		if(patientDetails.getClientId() < 1) {
			return clientDAO.insertClientDetails(patientDetails);
		} else {
			return clientDAO.updateClientDetails(patientDetails);
		}
	}
	
	public boolean deleteClientDetails(Client patientDetails) {
		return clientDAO.deleteClientDetails(patientDetails);
	}
}
