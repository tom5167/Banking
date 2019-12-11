package BankingSystemUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BankingSystemBusinessLogic.AdminLogic;
import BankingSystemConstants.CommonConstants;
import BankingSystemPOJO.Client;

public class AdminScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlClientDetails_A;
	private JTextField txtFirstName_ACF;
	private JTextField txtLastName_ACF;
	private JTextField txtContactNumber_ACF;
	private JTextField txtEmailId_ACF;
	private JTextField txtAddress_ACF;
	private JTextField txtPostalCode_ACF;
	AdminLogic adminLogic = new AdminLogic();
	private JTable tblClientList_ACL;
	private JTextField txtFirstName_ACL;
	private JTextField txtDateOfBirth_ACF;
	private JTextField txtPassword_ACF;
	private JTextField txtUsername_ACF;
	private JComboBox cmbAccNumber_ACF;
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	public AdminScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 408);
		pnlClientDetails_A = new JPanel();
		pnlClientDetails_A.setLayout(null);
		
		JPanel pnlClientForm_AC = new JPanel();
		pnlClientForm_AC.setBounds(0, 0, 493, 365);
		pnlClientDetails_A.add(pnlClientForm_AC);
		pnlClientForm_AC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Client Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_pnlClientForm_AC = new GridBagLayout();
		gbl_pnlClientForm_AC.columnWidths = new int[]{26, 95, 106, 79, 0, 0, 0};
		gbl_pnlClientForm_AC.rowHeights = new int[]{20, 0, 0, 20, 0, 0, 0, 0, 43, 0, 0};
		gbl_pnlClientForm_AC.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlClientForm_AC.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		pnlClientForm_AC.setLayout(gbl_pnlClientForm_AC);
		
		JLabel lblClientId_ACF = new JLabel("");
		lblClientId_ACF.setEnabled(false);
		GridBagConstraints gbc_lblClientId_ACF = new GridBagConstraints();
		gbc_lblClientId_ACF.fill = GridBagConstraints.VERTICAL;
		gbc_lblClientId_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientId_ACF.gridx = 2;
		gbc_lblClientId_ACF.gridy = 0;
		pnlClientForm_AC.add(lblClientId_ACF, gbc_lblClientId_ACF);
		
		JLabel lblUsername_ACF = new JLabel("Username");
		GridBagConstraints gbc_lblUsername_ACF = new GridBagConstraints();
		gbc_lblUsername_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblUsername_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername_ACF.gridx = 1;
		gbc_lblUsername_ACF.gridy = 1;
		pnlClientForm_AC.add(lblUsername_ACF, gbc_lblUsername_ACF);
		
		txtUsername_ACF = new JTextField();
		GridBagConstraints gbc_txtUsername_ACF = new GridBagConstraints();
		gbc_txtUsername_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername_ACF.gridx = 2;
		gbc_txtUsername_ACF.gridy = 1;
		pnlClientForm_AC.add(txtUsername_ACF, gbc_txtUsername_ACF);
		txtUsername_ACF.setColumns(10);
		
		JLabel lblDateOfBirth_ACF = new JLabel("Date of Birth");
		GridBagConstraints gbc_lblDateOfBirth_ACF = new GridBagConstraints();
		gbc_lblDateOfBirth_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblDateOfBirth_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth_ACF.gridx = 3;
		gbc_lblDateOfBirth_ACF.gridy = 1;
		pnlClientForm_AC.add(lblDateOfBirth_ACF, gbc_lblDateOfBirth_ACF);
		
		txtDateOfBirth_ACF = new JTextField();
		GridBagConstraints gbc_txtDateOfBirth_ACF = new GridBagConstraints();
		gbc_txtDateOfBirth_ACF.anchor = GridBagConstraints.NORTH;
		gbc_txtDateOfBirth_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateOfBirth_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateOfBirth_ACF.gridx = 4;
		gbc_txtDateOfBirth_ACF.gridy = 1;
		pnlClientForm_AC.add(txtDateOfBirth_ACF, gbc_txtDateOfBirth_ACF);
		txtDateOfBirth_ACF.setColumns(10);
		
		JLabel lblPassword_ACF = new JLabel("Password");
		GridBagConstraints gbc_lblPassword_ACF = new GridBagConstraints();
		gbc_lblPassword_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblPassword_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword_ACF.gridx = 1;
		gbc_lblPassword_ACF.gridy = 2;
		pnlClientForm_AC.add(lblPassword_ACF, gbc_lblPassword_ACF);
		
		txtPassword_ACF = new JTextField();
		GridBagConstraints gbc_txtPassword_ACF = new GridBagConstraints();
		gbc_txtPassword_ACF.anchor = GridBagConstraints.NORTH;
		gbc_txtPassword_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword_ACF.gridx = 2;
		gbc_txtPassword_ACF.gridy = 2;
		pnlClientForm_AC.add(txtPassword_ACF, gbc_txtPassword_ACF);
		txtPassword_ACF.setColumns(10);
		
		JLabel lblAddress_ACF = new JLabel("Address");
		GridBagConstraints gbc_lblAddress_ACF = new GridBagConstraints();
		gbc_lblAddress_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblAddress_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress_ACF.gridx = 3;
		gbc_lblAddress_ACF.gridy = 2;
		pnlClientForm_AC.add(lblAddress_ACF, gbc_lblAddress_ACF);
		
		txtAddress_ACF = new JTextField();
		GridBagConstraints gbc_txtAddress_ACF = new GridBagConstraints();
		gbc_txtAddress_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress_ACF.gridx = 4;
		gbc_txtAddress_ACF.gridy = 2;
		pnlClientForm_AC.add(txtAddress_ACF, gbc_txtAddress_ACF);
		txtAddress_ACF.setColumns(10);
		
		JLabel lblFirstName_ACF = new JLabel("First Name");
		GridBagConstraints gbc_lblFirstName_ACF = new GridBagConstraints();
		gbc_lblFirstName_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName_ACF.gridx = 1;
		gbc_lblFirstName_ACF.gridy = 3;
		pnlClientForm_AC.add(lblFirstName_ACF, gbc_lblFirstName_ACF);
		
		txtFirstName_ACF = new JTextField();
		GridBagConstraints gbc_txtFirstName_ACF = new GridBagConstraints();
		gbc_txtFirstName_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtFirstName_ACF.anchor = GridBagConstraints.NORTH;
		gbc_txtFirstName_ACF.gridx = 2;
		gbc_txtFirstName_ACF.gridy = 3;
		pnlClientForm_AC.add(txtFirstName_ACF, gbc_txtFirstName_ACF);
		txtFirstName_ACF.setColumns(10);
		
		JLabel lblPostalCode_ACF = new JLabel("Postal Code");
		GridBagConstraints gbc_lblPostalCode_ACF = new GridBagConstraints();
		gbc_lblPostalCode_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblPostalCode_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblPostalCode_ACF.gridx = 3;
		gbc_lblPostalCode_ACF.gridy = 3;
		pnlClientForm_AC.add(lblPostalCode_ACF, gbc_lblPostalCode_ACF);
		
		txtPostalCode_ACF = new JTextField();
		GridBagConstraints gbc_txtPostalCode_ACF = new GridBagConstraints();
		gbc_txtPostalCode_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtPostalCode_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPostalCode_ACF.gridx = 4;
		gbc_txtPostalCode_ACF.gridy = 3;
		pnlClientForm_AC.add(txtPostalCode_ACF, gbc_txtPostalCode_ACF);
		
		JLabel lblLastName_ACF = new JLabel("Last Name");
		GridBagConstraints gbc_lblLastName_ACF = new GridBagConstraints();
		gbc_lblLastName_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblLastName_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName_ACF.gridx = 1;
		gbc_lblLastName_ACF.gridy = 4;
		pnlClientForm_AC.add(lblLastName_ACF, gbc_lblLastName_ACF);
		
		txtLastName_ACF = new JTextField();
		GridBagConstraints gbc_txtLastName_ACF = new GridBagConstraints();
		gbc_txtLastName_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtLastName_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName_ACF.gridx = 2;
		gbc_txtLastName_ACF.gridy = 4;
		pnlClientForm_AC.add(txtLastName_ACF, gbc_txtLastName_ACF);
		txtLastName_ACF.setColumns(10);
		
		JLabel lblEmailId_ACF = new JLabel("Email Id");
		GridBagConstraints gbc_lblEmailId_ACF = new GridBagConstraints();
		gbc_lblEmailId_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblEmailId_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailId_ACF.gridx = 3;
		gbc_lblEmailId_ACF.gridy = 4;
		pnlClientForm_AC.add(lblEmailId_ACF, gbc_lblEmailId_ACF);
		
		txtEmailId_ACF = new JTextField();
		GridBagConstraints gbc_txtEmailId_ACF = new GridBagConstraints();
		gbc_txtEmailId_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmailId_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmailId_ACF.gridx = 4;
		gbc_txtEmailId_ACF.gridy = 4;
		pnlClientForm_AC.add(txtEmailId_ACF, gbc_txtEmailId_ACF);
		
		JLabel lblSex_ACF = new JLabel("Sex");
		GridBagConstraints gbc_lblSex_ACF = new GridBagConstraints();
		gbc_lblSex_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblSex_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblSex_ACF.gridx = 1;
		gbc_lblSex_ACF.gridy = 5;
		pnlClientForm_AC.add(lblSex_ACF, gbc_lblSex_ACF);
		
		JComboBox cmbSex_ACF = new JComboBox();
		cmbSex_ACF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Male", "Female", "Other"}));
		GridBagConstraints gbc_cmbSex_ACF = new GridBagConstraints();
		gbc_cmbSex_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbSex_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSex_ACF.gridx = 2;
		gbc_cmbSex_ACF.gridy = 5;
		pnlClientForm_AC.add(cmbSex_ACF, gbc_cmbSex_ACF);
		
		JLabel lblContactNumber_ACF = new JLabel("Contact Number");
		GridBagConstraints gbc_lblContactNumber_ACF = new GridBagConstraints();
		gbc_lblContactNumber_ACF.anchor = GridBagConstraints.EAST;
		gbc_lblContactNumber_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_lblContactNumber_ACF.gridx = 3;
		gbc_lblContactNumber_ACF.gridy = 5;
		pnlClientForm_AC.add(lblContactNumber_ACF, gbc_lblContactNumber_ACF);
		
		txtContactNumber_ACF = new JTextField();
		GridBagConstraints gbc_txtContactNumber_ACF = new GridBagConstraints();
		gbc_txtContactNumber_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_txtContactNumber_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtContactNumber_ACF.gridx = 4;
		gbc_txtContactNumber_ACF.gridy = 5;
		pnlClientForm_AC.add(txtContactNumber_ACF, gbc_txtContactNumber_ACF);
		txtContactNumber_ACF.setColumns(10);
		
		JButton btnDelete_ACF = new JButton("Delete");
		btnDelete_ACF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Client clientDetails = new Client();
				if(lblClientId_ACF.getText().equalsIgnoreCase("")) {
					clientDetails.setClientId(0);
				} else {
					clientDetails.setClientId(Integer.parseInt(lblClientId_ACF.getText()));
				}
				boolean flag = adminLogic.deleteClientDetails(clientDetails);
				if(flag) {
					JOptionPane.showMessageDialog(null, "Deleted successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnSave_ACF = new JButton("Save");
		btnSave_ACF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Client clientDetails = new Client();
				if(lblClientId_ACF.getText().equalsIgnoreCase("")) {
					clientDetails.setClientId(0);
				} else {
					clientDetails.setClientId(Integer.parseInt(lblClientId_ACF.getText()));
				}
				clientDetails.setUserName(txtUsername_ACF.getText());
				clientDetails.setPwd(txtPassword_ACF.getText());
				clientDetails.setFirstName(txtFirstName_ACF.getText());
				clientDetails.setLastName(txtLastName_ACF.getText());
				clientDetails.setSex(cmbSex_ACF.getSelectedItem().toString());
				clientDetails.setDob(txtDateOfBirth_ACF.getText());
				clientDetails.setAddress(txtAddress_ACF.getText());
				clientDetails.setZip(txtPostalCode_ACF.getText());
				clientDetails.setEmail(txtEmailId_ACF.getText());
				clientDetails.setPhoneNo(txtContactNumber_ACF.getText());
				clientDetails.setAccNumber(cmbAccNumber_ACF.getSelectedItem().toString());
				boolean flag = adminLogic.saveClientDetails(clientDetails);
				if(flag) {
					lblClientId_ACF.setText(CommonConstants.EMPTY_STRING);
					txtUsername_ACF.setText(CommonConstants.EMPTY_STRING);
					txtPassword_ACF.setText(CommonConstants.EMPTY_STRING);
					txtFirstName_ACF.setText(CommonConstants.EMPTY_STRING);
					txtLastName_ACF.setText(CommonConstants.EMPTY_STRING);
					cmbSex_ACF.setSelectedItem(CommonConstants.PLEASE_SELECT);
					txtDateOfBirth_ACF.setText(CommonConstants.EMPTY_STRING);
					txtAddress_ACF.setText(CommonConstants.EMPTY_STRING);
					txtPostalCode_ACF.setText(CommonConstants.EMPTY_STRING);
					txtEmailId_ACF.setText(CommonConstants.EMPTY_STRING);
					txtContactNumber_ACF.setText(CommonConstants.EMPTY_STRING);
					JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnNew_ACF = new JButton("New");
		btnNew_ACF.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblClientId_ACF.setText(CommonConstants.EMPTY_STRING);
				txtUsername_ACF.setText(CommonConstants.EMPTY_STRING);
				txtPassword_ACF.setText(CommonConstants.EMPTY_STRING);
				txtFirstName_ACF.setText(CommonConstants.EMPTY_STRING);
				txtLastName_ACF.setText(CommonConstants.EMPTY_STRING);
				cmbSex_ACF.setSelectedItem(CommonConstants.PLEASE_SELECT);
				txtDateOfBirth_ACF.setText(CommonConstants.EMPTY_STRING);
				txtAddress_ACF.setText(CommonConstants.EMPTY_STRING);
				txtPostalCode_ACF.setText(CommonConstants.EMPTY_STRING);
				txtEmailId_ACF.setText(CommonConstants.EMPTY_STRING);
				txtContactNumber_ACF.setText(CommonConstants.EMPTY_STRING);
			}
		});
		
		JLabel lblNumberOfAccount = new JLabel("Number of Account");
		GridBagConstraints gbc_lblNumberOfAccount = new GridBagConstraints();
		gbc_lblNumberOfAccount.anchor = GridBagConstraints.EAST;
		gbc_lblNumberOfAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfAccount.gridx = 2;
		gbc_lblNumberOfAccount.gridy = 7;
		pnlClientForm_AC.add(lblNumberOfAccount, gbc_lblNumberOfAccount);
		
		cmbAccNumber_ACF = new JComboBox();
		cmbAccNumber_ACF.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "1", "2", "3", "4", "5"}));
		GridBagConstraints gbc_cmbAccNumber_ACF = new GridBagConstraints();
		gbc_cmbAccNumber_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAccNumber_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAccNumber_ACF.gridx = 3;
		gbc_cmbAccNumber_ACF.gridy = 7;
		pnlClientForm_AC.add(cmbAccNumber_ACF, gbc_cmbAccNumber_ACF);
		GridBagConstraints gbc_btnNew_ACF = new GridBagConstraints();
		gbc_btnNew_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNew_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew_ACF.gridx = 2;
		gbc_btnNew_ACF.gridy = 8;
		pnlClientForm_AC.add(btnNew_ACF, gbc_btnNew_ACF);
		GridBagConstraints gbc_btnSave_ACF = new GridBagConstraints();
		gbc_btnSave_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave_ACF.gridx = 3;
		gbc_btnSave_ACF.gridy = 8;
		pnlClientForm_AC.add(btnSave_ACF, gbc_btnSave_ACF);
		GridBagConstraints gbc_btnDelete_ACF = new GridBagConstraints();
		gbc_btnDelete_ACF.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete_ACF.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete_ACF.gridx = 4;
		gbc_btnDelete_ACF.gridy = 8;
		pnlClientForm_AC.add(btnDelete_ACF, gbc_btnDelete_ACF);
		
		JPanel pnlClientList_AC = new JPanel();
		pnlClientList_AC.setBounds(493, 0, 465, 365);
		pnlClientDetails_A.add(pnlClientList_AC);
		pnlClientList_AC.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Client List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlClientList_AC.setLayout(null);
		
		tblClientList_ACL = new JTable();
		tblClientList_ACL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DefaultTableModel modelClient = (DefaultTableModel) tblClientList_ACL.getModel();
				int selectedRowIndex = tblClientList_ACL.getSelectedRow();
				if(selectedRowIndex > -1) {
					lblClientId_ACF.setText(modelClient.getValueAt(selectedRowIndex, 0).toString());
					txtUsername_ACF.setText(modelClient.getValueAt(selectedRowIndex, 1).toString());
					txtPassword_ACF.setText(modelClient.getValueAt(selectedRowIndex, 2).toString());
					txtFirstName_ACF.setText(modelClient.getValueAt(selectedRowIndex, 3).toString());
					txtLastName_ACF.setText(modelClient.getValueAt(selectedRowIndex, 4).toString());
					cmbSex_ACF.setSelectedItem(modelClient.getValueAt(selectedRowIndex, 5).toString());
					txtDateOfBirth_ACF.setText(modelClient.getValueAt(selectedRowIndex, 6).toString());
					txtAddress_ACF.setText(modelClient.getValueAt(selectedRowIndex, 7).toString());
					txtPostalCode_ACF.setText(modelClient.getValueAt(selectedRowIndex, 8).toString());
					txtEmailId_ACF.setText(modelClient.getValueAt(selectedRowIndex, 9).toString());
					txtContactNumber_ACF.setText(modelClient.getValueAt(selectedRowIndex, 10).toString());
				}
			}
		});
		tblClientList_ACL.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Client Id", "Username", "Password", "First Name", "Last Name", "Sex", "Date of Birth", "Address", "Postal Code", "Email Id", "Contact Number", "Created By", "Created Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		tblClientList_ACL.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scrollClientList_ACL = new JScrollPane(tblClientList_ACL);
		scrollClientList_ACL.setBounds(6, 73, 449, 286);
		pnlClientList_AC.add(scrollClientList_ACL);
		
		JLabel lblFirstName_ACL = new JLabel("First Name");
		lblFirstName_ACL.setBounds(10, 23, 51, 14);
		pnlClientList_AC.add(lblFirstName_ACL);
		
		txtFirstName_ACL = new JTextField();
		txtFirstName_ACL.setColumns(10);
		txtFirstName_ACL.setBounds(70, 20, 127, 20);
		pnlClientList_AC.add(txtFirstName_ACL);
		
		JButton btnSearch_ACL = new JButton("Search");
		btnSearch_ACL.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtFirstName_ACL.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Please enter the first name to search", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				DefaultTableModel modelClient = (DefaultTableModel) tblClientList_ACL.getModel();
				List<Client> alClientDetails = adminLogic.getAlClientDetails(txtFirstName_ACL.getText());
				modelClient.setRowCount(0);
				if(alClientDetails.size() == 0) {
					JOptionPane.showMessageDialog(null, "No record found", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i=0;i<alClientDetails.size();i++) {
						Object[] row = new String[21];
						row[0] = alClientDetails.get(i).getClientId()+"";
						row[1] = alClientDetails.get(i).getUserName();
						row[2] = alClientDetails.get(i).getPwd();
						row[3] = alClientDetails.get(i).getFirstName();
						row[4] = alClientDetails.get(i).getLastName();
						row[5] = alClientDetails.get(i).getSex();
						row[6] = alClientDetails.get(i).getDob();
						row[7] = alClientDetails.get(i).getAddress();
						row[8] = alClientDetails.get(i).getZip();
						row[9] = alClientDetails.get(i).getEmail();
						row[10] = alClientDetails.get(i).getPhoneNo();
						modelClient.addRow(row);
					}
				}
			}
		});
		btnSearch_ACL.setBounds(366, 19, 89, 23);
		pnlClientList_AC.add(btnSearch_ACL);
		
		JLabel lblNote_ACL = new JLabel("  Note: Result will show similar first names apart from exact match.");
		lblNote_ACL.setBounds(6, 48, 445, 14);
		pnlClientList_AC.add(lblNote_ACL);
		
		getContentPane().add(pnlClientDetails_A);
	}

}
