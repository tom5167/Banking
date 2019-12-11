package BankingSystemUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import BankingSystemBusinessLogic.LoginLogic;
import BankingSystemConstants.CommonConstants;
import BankingSystemPOJO.User;
import BankingSystemUtil.CommonUtil;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class BankMainUI {

	private JFrame bankUI;
	private JPanel welcomePanel;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	CommonUtil commonUtil = new CommonUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankMainUI window = new BankMainUI();
					window.bankUI.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankMainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		bankUI = new JFrame();
		bankUI.setTitle("Bank Care");
		bankUI.setResizable(false);
		bankUI.setBounds(200, 10, 343, 211);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		bankUI.setLocation(dim.width/2-bankUI.getSize().width/2, dim.height/2-bankUI.getSize().height/2);
		
		bankUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bankUI.getContentPane().setLayout(new CardLayout(0, 0));
		
		welcomePanel = new JPanel();
		bankUI.getContentPane().add(welcomePanel, "welcomePanel");
		welcomePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		welcomePanel.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{31, 20, 78, 145, 86, 0};
		gbl_panel.rowHeights = new int[]{0, 20, 23, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.BLACK);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 2;
		gbc_lblUsername.gridy = 1;
		panel.add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField(10);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername.anchor = GridBagConstraints.NORTH;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 3;
		gbc_txtUsername.gridy = 1;
		panel.add(txtUsername, gbc_txtUsername);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 2;
		gbc_lblPassword.gridy = 2;
		panel.add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JPasswordField(10);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.anchor = GridBagConstraints.NORTH;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.gridx = 3;
		gbc_txtPassword.gridy = 2;
		panel.add(txtPassword, gbc_txtPassword);
		
		JLabel lblUserType = new JLabel("User Type");
		GridBagConstraints gbc_lblUserType = new GridBagConstraints();
		gbc_lblUserType.anchor = GridBagConstraints.EAST;
		gbc_lblUserType.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserType.gridx = 2;
		gbc_lblUserType.gridy = 3;
		panel.add(lblUserType, gbc_lblUserType);
		
		JComboBox cmbUserType = new JComboBox();
		cmbUserType.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Admin", "Client"}));
		GridBagConstraints gbc_cmbUserType = new GridBagConstraints();
		gbc_cmbUserType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbUserType.insets = new Insets(0, 0, 5, 5);
		gbc_cmbUserType.gridx = 3;
		gbc_cmbUserType.gridy = 3;
		panel.add(cmbUserType, gbc_cmbUserType);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mousePressed(MouseEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				LoginLogic loginObj = new LoginLogic();
				if (username.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the username", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				if (password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the password", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				if (cmbUserType.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Please select a user", "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (loginObj.checkUser(username, password, cmbUserType.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(null, "Welcome - " + username, "Success",
							JOptionPane.INFORMATION_MESSAGE);
					User userObj = new User();
					userObj = loginObj.getUserDetails(username, password, cmbUserType.getSelectedItem().toString());
					commonUtil.setUserId(userObj.getUserId());
					if (userObj.getUserType().equalsIgnoreCase(CommonConstants.ADMIN)) {
						AdminScreen adminScreen = new AdminScreen();
						adminScreen.setVisible(true);
						bankUI.setVisible(false);
					} else if (userObj.getUserType().equalsIgnoreCase(CommonConstants.CLIENT)) {
						ClientScreen clientScreen = new ClientScreen();
						clientScreen.setVisible(true);
						bankUI.setVisible(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect login or password", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 4;
		panel.add(btnLogin, gbc_btnLogin);
		
		JMenuBar menuBar = new JMenuBar();
		bankUI.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(bankUI, "Are you sure you want to close the application?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAboutUs = new JMenuItem("About Us");
		mntmAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Bank Care", "About Us", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAboutUs);
	}
	
}

