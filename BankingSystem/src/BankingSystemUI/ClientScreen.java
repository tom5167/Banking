package BankingSystemUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import BankingSystemBusinessLogic.ClientLogic;
import BankingSystemConstants.CommonConstants;
import BankingSystemPOJO.Bill;
import BankingSystemPOJO.Transaction;

public class ClientScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	ClientLogic clientLogic = new ClientLogic();
	private JPanel pnlDeposit;
	private JComboBox cmbAccountType_D;
	private JLabel lblDepositAmount_D;
	private JTextField txtDepositAmount_D;
	private JButton btnDeposit_D;
	private JPanel pnlAccountBalance;
	private JComboBox cmbAccountNumber_A;
	private JLabel lblAccountBalance_A;
	private JLabel lblAccountBalanceValue_A;
	private JLabel lblChequing_A;
	private JLabel lblChequingAmount_A;
	private JLabel lblSaving_A;
	private JLabel lblSavingAmount_A;
	private JPanel pnlWithdraw;
	private JComboBox cmbAccountType_W;
	private JLabel lblDrawAmount_W;
	private JTextField txtDrawAmount_W;
	private JButton btnDraw_W;
	private JPanel pnlTransfer;
	private JLabel lblFrom_T;
	private JComboBox cmbFrom_T;
	private JLabel lblTo_T;
	private JComboBox cmbTo_T;
	private JLabel lblTransferAmount_T;
	private JTextField txtTransferAmount_T;
	private JButton btnTransfer_T;
	private JLabel lblAccountNumber_A;
	private JLabel lblAccountType_D;
	private JLabel lblAccountType_W;
	private JPanel pnlBill;
	private JComboBox cmbBillNumber_B;
	private JComboBox cmbAccountType_B;
	private JLabel lblBillAmount_B;
	private JButton btnPayBill_B;
	private JLabel txtAccountType_B;
	private JLabel lblBillNumber_B;
	private JLabel lblBillAmountValue_B;
	private JLabel lblBillType_B;
	private JLabel lblBillTypeValue_B;

	@SuppressWarnings("unchecked")
	public ClientScreen() {
		setTitle("WELCOME TO ONLINE BANKING");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 450, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 105, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		
		pnlAccountBalance = new JPanel();
		pnlAccountBalance.setBorder(new TitledBorder(null, "Account Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlAccountBalance = new GridBagConstraints();
		gbc_pnlAccountBalance.insets = new Insets(0, 0, 5, 5);
		gbc_pnlAccountBalance.fill = GridBagConstraints.BOTH;
		gbc_pnlAccountBalance.gridx = 0;
		gbc_pnlAccountBalance.gridy = 0;
		getContentPane().add(pnlAccountBalance, gbc_pnlAccountBalance);
		
		GridBagLayout gbl_pnlAccountBalance = new GridBagLayout();
		gbl_pnlAccountBalance.columnWidths = new int[]{44, 135, 168, 0, 0};
		gbl_pnlAccountBalance.rowHeights = new int[]{0, 20, 0, 0, 0, 0, 0};
		gbl_pnlAccountBalance.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlAccountBalance.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlAccountBalance.setLayout(gbl_pnlAccountBalance);
		
		lblAccountNumber_A = new JLabel("Account Number");
		GridBagConstraints gbc_lblAccountNumber_A = new GridBagConstraints();
		gbc_lblAccountNumber_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountNumber_A.anchor = GridBagConstraints.EAST;
		gbc_lblAccountNumber_A.gridx = 1;
		gbc_lblAccountNumber_A.gridy = 1;
		pnlAccountBalance.add(lblAccountNumber_A, gbc_lblAccountNumber_A);
		
		cmbAccountNumber_A = new JComboBox();
		
		cmbAccountNumber_A.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbAccountNumber_A = new GridBagConstraints();
		gbc_cmbAccountNumber_A.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAccountNumber_A.anchor = GridBagConstraints.NORTH;
		gbc_cmbAccountNumber_A.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAccountNumber_A.gridx = 2;
		gbc_cmbAccountNumber_A.gridy = 1;
		pnlAccountBalance.add(cmbAccountNumber_A, gbc_cmbAccountNumber_A);
		
		cmbAccountNumber_A.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmbAccountNumber_A.getSelectedItem() != null) {
					String accNumber = cmbAccountNumber_A.getSelectedItem().toString();
					if(!accNumber.equalsIgnoreCase("Please Select")) {
						Transaction accDetails = clientLogic.getAccDetails(accNumber);
						lblChequingAmount_A.setText(accDetails.getCheqBalance()+"");
						lblSavingAmount_A.setText(accDetails.getSavBalance()+"");
						lblAccountBalanceValue_A.setText(accDetails.getTotalBalance()+"");
					}
				}
			}
		});
		
		lblChequing_A = new JLabel("Cheqing Account Balance");
		GridBagConstraints gbc_lblChequing_A = new GridBagConstraints();
		gbc_lblChequing_A.anchor = GridBagConstraints.EAST;
		gbc_lblChequing_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblChequing_A.gridx = 1;
		gbc_lblChequing_A.gridy = 2;
		pnlAccountBalance.add(lblChequing_A, gbc_lblChequing_A);
		
		lblChequingAmount_A = new JLabel("0.0");
		GridBagConstraints gbc_lblChequingAmount_A = new GridBagConstraints();
		gbc_lblChequingAmount_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblChequingAmount_A.gridx = 2;
		gbc_lblChequingAmount_A.gridy = 2;
		pnlAccountBalance.add(lblChequingAmount_A, gbc_lblChequingAmount_A);
		
		lblSaving_A = new JLabel("Savings Account Balance");
		GridBagConstraints gbc_lblSaving_A = new GridBagConstraints();
		gbc_lblSaving_A.anchor = GridBagConstraints.EAST;
		gbc_lblSaving_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblSaving_A.gridx = 1;
		gbc_lblSaving_A.gridy = 3;
		pnlAccountBalance.add(lblSaving_A, gbc_lblSaving_A);
		
		lblSavingAmount_A = new JLabel("0.0");
		GridBagConstraints gbc_lblSavingAmount_A = new GridBagConstraints();
		gbc_lblSavingAmount_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblSavingAmount_A.gridx = 2;
		gbc_lblSavingAmount_A.gridy = 3;
		pnlAccountBalance.add(lblSavingAmount_A, gbc_lblSavingAmount_A);
		
		lblAccountBalance_A = new JLabel("Total Account Balance");
		GridBagConstraints gbc_lblAccountBalance_A = new GridBagConstraints();
		gbc_lblAccountBalance_A.anchor = GridBagConstraints.EAST;
		gbc_lblAccountBalance_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountBalance_A.gridx = 1;
		gbc_lblAccountBalance_A.gridy = 4;
		pnlAccountBalance.add(lblAccountBalance_A, gbc_lblAccountBalance_A);
		
		lblAccountBalanceValue_A = new JLabel("0.0");
		GridBagConstraints gbc_lblAccountBalanceValue_A = new GridBagConstraints();
		gbc_lblAccountBalanceValue_A.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountBalanceValue_A.gridx = 2;
		gbc_lblAccountBalanceValue_A.gridy = 4;
		pnlAccountBalance.add(lblAccountBalanceValue_A, gbc_lblAccountBalanceValue_A);
		
		pnlDeposit = new JPanel();
		pnlDeposit.setBorder(new TitledBorder(null, "DEPOSIT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlDeposit = new GridBagConstraints();
		gbc_pnlDeposit.insets = new Insets(0, 0, 5, 5);
		gbc_pnlDeposit.fill = GridBagConstraints.BOTH;
		gbc_pnlDeposit.gridx = 0;
		gbc_pnlDeposit.gridy = 1;
		getContentPane().add(pnlDeposit, gbc_pnlDeposit);
		GridBagLayout gbl_pnlDeposit = new GridBagLayout();
		gbl_pnlDeposit.columnWidths = new int[]{154, 199, 0};
		gbl_pnlDeposit.rowHeights = new int[]{0, 20, 0, 0, 0, 0};
		gbl_pnlDeposit.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDeposit.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlDeposit.setLayout(gbl_pnlDeposit);
		
		lblAccountType_D = new JLabel("Account Type");
		GridBagConstraints gbc_lblAccountType_D = new GridBagConstraints();
		gbc_lblAccountType_D.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountType_D.anchor = GridBagConstraints.EAST;
		gbc_lblAccountType_D.gridx = 0;
		gbc_lblAccountType_D.gridy = 1;
		pnlDeposit.add(lblAccountType_D, gbc_lblAccountType_D);
		
		cmbAccountType_D = new JComboBox();
		cmbAccountType_D.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Chequing", "Saving"}));
		GridBagConstraints gbc_cmbAccountType_D = new GridBagConstraints();
		gbc_cmbAccountType_D.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAccountType_D.anchor = GridBagConstraints.NORTH;
		gbc_cmbAccountType_D.insets = new Insets(0, 0, 5, 0);
		gbc_cmbAccountType_D.gridx = 1;
		gbc_cmbAccountType_D.gridy = 1;
		pnlDeposit.add(cmbAccountType_D, gbc_cmbAccountType_D);
		
		lblDepositAmount_D = new JLabel("Enter the amount :");
		GridBagConstraints gbc_lblDepositAmount_D = new GridBagConstraints();
		gbc_lblDepositAmount_D.anchor = GridBagConstraints.EAST;
		gbc_lblDepositAmount_D.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepositAmount_D.gridx = 0;
		gbc_lblDepositAmount_D.gridy = 2;
		pnlDeposit.add(lblDepositAmount_D, gbc_lblDepositAmount_D);
		
		txtDepositAmount_D = new JTextField(10);
		GridBagConstraints gbc_txtDepositAmount_D = new GridBagConstraints();
		gbc_txtDepositAmount_D.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDepositAmount_D.insets = new Insets(0, 0, 5, 0);
		gbc_txtDepositAmount_D.gridx = 1;
		gbc_txtDepositAmount_D.gridy = 2;
		pnlDeposit.add(txtDepositAmount_D, gbc_txtDepositAmount_D);
		
		btnDeposit_D = new JButton("Deposit");
		btnDeposit_D.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Transaction transObj = new Transaction();
				transObj.setAccNumber(cmbAccountNumber_A.getSelectedItem().toString());
				transObj.setAccType(cmbAccountType_D.getSelectedItem().toString());
				transObj.setAmount(Double.parseDouble(txtDepositAmount_D.getText()));
				transObj.setCheqBalance(Double.parseDouble(lblChequingAmount_A.getText()));
				transObj.setSavBalance(Double.parseDouble(lblSavingAmount_A.getText()));
				if(transObj.getAccNumber().equalsIgnoreCase("Please Select")) {
					JOptionPane.showMessageDialog(null, "Please select the account number", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				boolean flag = clientLogic.depositAmount(transObj);
				if(flag) {
					loadClientScreen();
					JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnDeposit_D = new GridBagConstraints();
		gbc_btnDeposit_D.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeposit_D.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeposit_D.gridx = 1;
		gbc_btnDeposit_D.gridy = 3;
		pnlDeposit.add(btnDeposit_D, gbc_btnDeposit_D);
		
		pnlWithdraw = new JPanel();
		pnlWithdraw.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "WITHDRAW", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlWithdraw = new GridBagConstraints();
		gbc_pnlWithdraw.insets = new Insets(0, 0, 5, 0);
		gbc_pnlWithdraw.fill = GridBagConstraints.BOTH;
		gbc_pnlWithdraw.gridx = 1;
		gbc_pnlWithdraw.gridy = 1;
		getContentPane().add(pnlWithdraw, gbc_pnlWithdraw);
		GridBagLayout gbl_pnlWithdraw = new GridBagLayout();
		gbl_pnlWithdraw.columnWidths = new int[]{30, 122, 205, 0, 0};
		gbl_pnlWithdraw.rowHeights = new int[]{0, 20, 20, 23, 0, 0};
		gbl_pnlWithdraw.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlWithdraw.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlWithdraw.setLayout(gbl_pnlWithdraw);
		
		lblAccountType_W = new JLabel("Account Type");
		GridBagConstraints gbc_lblAccountType_W = new GridBagConstraints();
		gbc_lblAccountType_W.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccountType_W.anchor = GridBagConstraints.EAST;
		gbc_lblAccountType_W.gridx = 1;
		gbc_lblAccountType_W.gridy = 1;
		pnlWithdraw.add(lblAccountType_W, gbc_lblAccountType_W);
		
		cmbAccountType_W = new JComboBox();
		cmbAccountType_W.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Chequing", "Saving"}));
		GridBagConstraints gbc_cmbAccountType_W = new GridBagConstraints();
		gbc_cmbAccountType_W.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAccountType_W.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAccountType_W.gridx = 2;
		gbc_cmbAccountType_W.gridy = 1;
		pnlWithdraw.add(cmbAccountType_W, gbc_cmbAccountType_W);
		
		lblDrawAmount_W = new JLabel("Enter the amount :");
		GridBagConstraints gbc_lblDrawAmount_W = new GridBagConstraints();
		gbc_lblDrawAmount_W.anchor = GridBagConstraints.EAST;
		gbc_lblDrawAmount_W.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrawAmount_W.gridx = 1;
		gbc_lblDrawAmount_W.gridy = 2;
		pnlWithdraw.add(lblDrawAmount_W, gbc_lblDrawAmount_W);
		
		txtDrawAmount_W = new JTextField(10);
		GridBagConstraints gbc_txtDrawAmount_W = new GridBagConstraints();
		gbc_txtDrawAmount_W.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrawAmount_W.insets = new Insets(0, 0, 5, 5);
		gbc_txtDrawAmount_W.gridx = 2;
		gbc_txtDrawAmount_W.gridy = 2;
		pnlWithdraw.add(txtDrawAmount_W, gbc_txtDrawAmount_W);
		
		btnDraw_W = new JButton("Draw");
		btnDraw_W.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Transaction transObj = new Transaction();
				transObj.setAccNumber(cmbAccountNumber_A.getSelectedItem().toString());
				transObj.setAccType(cmbAccountType_W.getSelectedItem().toString());
				transObj.setAmount(Double.parseDouble(txtDrawAmount_W.getText()));
				transObj.setCheqBalance(Double.parseDouble(lblChequingAmount_A.getText()));
				transObj.setSavBalance(Double.parseDouble(lblSavingAmount_A.getText()));
				if(transObj.getAccNumber().equalsIgnoreCase("Please Select")) {
					JOptionPane.showMessageDialog(null, "Please select the account number", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				//checking for amount
				if(transObj.getAccType().toString().equalsIgnoreCase("Chequing")) {
					if(transObj.getAmount() > transObj.getCheqBalance()) {
						JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if (transObj.getAccType().toString().equalsIgnoreCase("Saving")) {
					if(transObj.getAmount() > transObj.getSavBalance()) {
						JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				boolean flag = clientLogic.withdrawAmount(transObj);
				if(flag) {
					loadClientScreen();
					JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnDraw_W = new GridBagConstraints();
		gbc_btnDraw_W.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDraw_W.anchor = GridBagConstraints.NORTH;
		gbc_btnDraw_W.insets = new Insets(0, 0, 5, 5);
		gbc_btnDraw_W.gridx = 2;
		gbc_btnDraw_W.gridy = 3;
		pnlWithdraw.add(btnDraw_W, gbc_btnDraw_W);
		
		pnlTransfer = new JPanel();
		pnlTransfer.setBorder(new TitledBorder(null, "TRANSFER", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlTransfer = new GridBagConstraints();
		gbc_pnlTransfer.insets = new Insets(0, 0, 5, 5);
		gbc_pnlTransfer.fill = GridBagConstraints.BOTH;
		gbc_pnlTransfer.gridx = 0;
		gbc_pnlTransfer.gridy = 2;
		getContentPane().add(pnlTransfer, gbc_pnlTransfer);
		GridBagLayout gbl_pnlTransfer = new GridBagLayout();
		gbl_pnlTransfer.columnWidths = new int[]{44, 108, 201, 0, 0};
		gbl_pnlTransfer.rowHeights = new int[]{0, 20, 0, 0, 0, 0, 0};
		gbl_pnlTransfer.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlTransfer.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlTransfer.setLayout(gbl_pnlTransfer);
		
		lblFrom_T = new JLabel("From");
		GridBagConstraints gbc_lblFrom_T = new GridBagConstraints();
		gbc_lblFrom_T.anchor = GridBagConstraints.EAST;
		gbc_lblFrom_T.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrom_T.gridx = 1;
		gbc_lblFrom_T.gridy = 1;
		pnlTransfer.add(lblFrom_T, gbc_lblFrom_T);
		
		cmbFrom_T = new JComboBox();
		cmbFrom_T.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Chequing", "Saving"}));
		GridBagConstraints gbc_cmbFrom_T = new GridBagConstraints();
		gbc_cmbFrom_T.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbFrom_T.anchor = GridBagConstraints.NORTH;
		gbc_cmbFrom_T.insets = new Insets(0, 0, 5, 5);
		gbc_cmbFrom_T.gridx = 2;
		gbc_cmbFrom_T.gridy = 1;
		pnlTransfer.add(cmbFrom_T, gbc_cmbFrom_T);
		
		lblTo_T = new JLabel("To");
		GridBagConstraints gbc_lblTo_T = new GridBagConstraints();
		gbc_lblTo_T.anchor = GridBagConstraints.EAST;
		gbc_lblTo_T.insets = new Insets(0, 0, 5, 5);
		gbc_lblTo_T.gridx = 1;
		gbc_lblTo_T.gridy = 2;
		pnlTransfer.add(lblTo_T, gbc_lblTo_T);
		
		cmbTo_T = new JComboBox();
		cmbTo_T.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Chequing", "Saving"}));
		GridBagConstraints gbc_cmbTo_T = new GridBagConstraints();
		gbc_cmbTo_T.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbTo_T.insets = new Insets(0, 0, 5, 5);
		gbc_cmbTo_T.gridx = 2;
		gbc_cmbTo_T.gridy = 2;
		pnlTransfer.add(cmbTo_T, gbc_cmbTo_T);
		
		lblTransferAmount_T = new JLabel("Enter the amount :");
		GridBagConstraints gbc_lblTransferAmount_T = new GridBagConstraints();
		gbc_lblTransferAmount_T.anchor = GridBagConstraints.EAST;
		gbc_lblTransferAmount_T.insets = new Insets(0, 0, 5, 5);
		gbc_lblTransferAmount_T.gridx = 1;
		gbc_lblTransferAmount_T.gridy = 3;
		pnlTransfer.add(lblTransferAmount_T, gbc_lblTransferAmount_T);
		
		txtTransferAmount_T = new JTextField(10);
		GridBagConstraints gbc_txtTransferAmount_T = new GridBagConstraints();
		gbc_txtTransferAmount_T.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTransferAmount_T.insets = new Insets(0, 0, 5, 5);
		gbc_txtTransferAmount_T.gridx = 2;
		gbc_txtTransferAmount_T.gridy = 3;
		pnlTransfer.add(txtTransferAmount_T, gbc_txtTransferAmount_T);
		
		btnTransfer_T = new JButton("Transfer");
		btnTransfer_T.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Transaction transObj = new Transaction();
				transObj.setAccNumber(cmbAccountNumber_A.getSelectedItem().toString());
				transObj.setFromAcc(cmbFrom_T.getSelectedItem().toString());
				transObj.setToAcc(cmbTo_T.getSelectedItem().toString());
				transObj.setAmount(Double.parseDouble(txtTransferAmount_T.getText()));
				transObj.setCheqBalance(Double.parseDouble(lblChequingAmount_A.getText()));
				transObj.setSavBalance(Double.parseDouble(lblSavingAmount_A.getText()));
				if(transObj.getAccNumber().equalsIgnoreCase("Please Select")) {
					JOptionPane.showMessageDialog(null, "Please select the account number", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(transObj.getFromAcc().toString().equalsIgnoreCase("Chequing")) {
					if(transObj.getAmount()	> transObj.getCheqBalance()) {
						JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if (transObj.getFromAcc().toString().equalsIgnoreCase("Saving")) {
					if(transObj.getAmount()	> transObj.getSavBalance()) {
						JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				boolean flag = clientLogic.transferAmount(transObj);
				if(flag) {
					loadClientScreen();
					JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnTransfer_T = new GridBagConstraints();
		gbc_btnTransfer_T.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTransfer_T.insets = new Insets(0, 0, 5, 5);
		gbc_btnTransfer_T.gridx = 2;
		gbc_btnTransfer_T.gridy = 4;
		pnlTransfer.add(btnTransfer_T, gbc_btnTransfer_T);
		
		pnlBill = new JPanel();
		pnlBill.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BILL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_pnlBill = new GridBagConstraints();
		gbc_pnlBill.insets = new Insets(0, 0, 5, 0);
		gbc_pnlBill.fill = GridBagConstraints.BOTH;
		gbc_pnlBill.gridx = 1;
		gbc_pnlBill.gridy = 2;
		getContentPane().add(pnlBill, gbc_pnlBill);
		GridBagLayout gbl_pnlBill = new GridBagLayout();
		gbl_pnlBill.columnWidths = new int[]{44, 108, 201, 0, 0};
		gbl_pnlBill.rowHeights = new int[]{0, 20, 0, 0, 0, 0, 0, 0};
		gbl_pnlBill.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBill.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlBill.setLayout(gbl_pnlBill);
		
		lblBillNumber_B = new JLabel("Bill Number");
		GridBagConstraints gbc_lblBillNumber_B = new GridBagConstraints();
		gbc_lblBillNumber_B.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillNumber_B.anchor = GridBagConstraints.EAST;
		gbc_lblBillNumber_B.gridx = 1;
		gbc_lblBillNumber_B.gridy = 1;
		pnlBill.add(lblBillNumber_B, gbc_lblBillNumber_B);
		
		cmbBillNumber_B = new JComboBox();
		cmbBillNumber_B.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmbBillNumber_B.getSelectedItem() != null) {
					String billNumber = cmbBillNumber_B.getSelectedItem().toString();
					if(!billNumber.equalsIgnoreCase("Please Select")) {
						List<Bill> billDetails = clientLogic.getAlBillDetails();
						for(int i=0;i<billDetails.size();i++) {
							if(billNumber.equalsIgnoreCase(billDetails.get(i).getBillId()+"")) {
								lblBillTypeValue_B.setText(billDetails.get(i).getBillType());
								lblBillAmountValue_B.setText(billDetails.get(i).getBillAmount()+"");
							}
						}
					}
				}
			}
		});
		cmbBillNumber_B.setModel(new DefaultComboBoxModel(new String[] {"Please Select"}));
		GridBagConstraints gbc_cmbBillNumber_B = new GridBagConstraints();
		gbc_cmbBillNumber_B.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbBillNumber_B.anchor = GridBagConstraints.NORTH;
		gbc_cmbBillNumber_B.insets = new Insets(0, 0, 5, 5);
		gbc_cmbBillNumber_B.gridx = 2;
		gbc_cmbBillNumber_B.gridy = 1;
		pnlBill.add(cmbBillNumber_B, gbc_cmbBillNumber_B);
		
		lblBillType_B = new JLabel("Bill Type");
		GridBagConstraints gbc_lblBillType_B = new GridBagConstraints();
		gbc_lblBillType_B.anchor = GridBagConstraints.EAST;
		gbc_lblBillType_B.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillType_B.gridx = 1;
		gbc_lblBillType_B.gridy = 2;
		pnlBill.add(lblBillType_B, gbc_lblBillType_B);
		
		lblBillTypeValue_B = new JLabel("");
		GridBagConstraints gbc_lblBillTypeValue_B = new GridBagConstraints();
		gbc_lblBillTypeValue_B.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillTypeValue_B.gridx = 2;
		gbc_lblBillTypeValue_B.gridy = 2;
		pnlBill.add(lblBillTypeValue_B, gbc_lblBillTypeValue_B);
		
		lblBillAmount_B = new JLabel("Enter the amount :");
		GridBagConstraints gbc_lblBillAmount_B = new GridBagConstraints();
		gbc_lblBillAmount_B.anchor = GridBagConstraints.EAST;
		gbc_lblBillAmount_B.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillAmount_B.gridx = 1;
		gbc_lblBillAmount_B.gridy = 3;
		pnlBill.add(lblBillAmount_B, gbc_lblBillAmount_B);
		
		lblBillAmountValue_B = new JLabel("");
		GridBagConstraints gbc_lblBillAmountValue_B = new GridBagConstraints();
		gbc_lblBillAmountValue_B.insets = new Insets(0, 0, 5, 5);
		gbc_lblBillAmountValue_B.gridx = 2;
		gbc_lblBillAmountValue_B.gridy = 3;
		pnlBill.add(lblBillAmountValue_B, gbc_lblBillAmountValue_B);
		
		txtAccountType_B = new JLabel("Account Type");
		GridBagConstraints gbc_txtAccountType_B = new GridBagConstraints();
		gbc_txtAccountType_B.insets = new Insets(0, 0, 5, 5);
		gbc_txtAccountType_B.anchor = GridBagConstraints.EAST;
		gbc_txtAccountType_B.gridx = 1;
		gbc_txtAccountType_B.gridy = 4;
		pnlBill.add(txtAccountType_B, gbc_txtAccountType_B);
		
		cmbAccountType_B = new JComboBox();
		cmbAccountType_B.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Chequing", "Saving"}));
		GridBagConstraints gbc_cmbAccountType_B = new GridBagConstraints();
		gbc_cmbAccountType_B.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbAccountType_B.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAccountType_B.gridx = 2;
		gbc_cmbAccountType_B.gridy = 4;
		pnlBill.add(cmbAccountType_B, gbc_cmbAccountType_B);
		
		btnPayBill_B = new JButton("Pay Bill");
		btnPayBill_B.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bill bill = new Bill();
				bill.setBillId(Integer.parseInt(cmbBillNumber_B.getSelectedItem().toString()));
				bill.setAccNumber(cmbAccountNumber_A.getSelectedItem().toString());
				bill.setAccType(cmbAccountType_B.getSelectedItem().toString());
				bill.setBillAmount(Double.parseDouble(lblBillAmountValue_B.getText()));
				bill.setBillType(lblBillTypeValue_B.getText());
				bill.setCheqBalance(Double.parseDouble(lblChequingAmount_A.getText()));
				bill.setSavBalance(Double.parseDouble(lblSavingAmount_A.getText()));
				if(bill.getAccNumber().equalsIgnoreCase("Please Select")) {
					JOptionPane.showMessageDialog(null, "Please select the account number", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(bill.getAccType().toString().equalsIgnoreCase("Chequing")) {
					if(bill.getBillAmount()
							> Double.parseDouble(lblChequingAmount_A.getText())) {
						JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else if (bill.getAccType().toString().equalsIgnoreCase("Saving")) {
					if(bill.getBillAmount()
							> Double.parseDouble(lblSavingAmount_A.getText())) {
						JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				boolean flag = clientLogic.updateBillDetails(bill);
				if(flag) {
					loadClientScreen();
					JOptionPane.showMessageDialog(null, "Saved successfully", "Success",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error occurred while saving, Please check your balance", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnPayBill_B = new GridBagConstraints();
		gbc_btnPayBill_B.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPayBill_B.insets = new Insets(0, 0, 5, 5);
		gbc_btnPayBill_B.gridx = 2;
		gbc_btnPayBill_B.gridy = 5;
		pnlBill.add(btnPayBill_B, gbc_btnPayBill_B);

		// Pack the contents of the window and display it.
		pack();
		loadClientScreen();
		setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void loadClientScreen() {
		List<Transaction> accDetails = clientLogic.getAlAccDetails();
		if(accDetails.size() == 0) {
			cmbAccountNumber_A.removeAllItems();
			cmbAccountNumber_A.addItem(CommonConstants.PLEASE_SELECT);
		} else {
			cmbAccountNumber_A.removeAllItems();
			cmbAccountNumber_A.addItem(CommonConstants.PLEASE_SELECT);
			for(int i=0;i<accDetails.size();i++) {
				cmbAccountNumber_A.addItem(accDetails.get(i).getAccNumber());
			}
		}
		
		if(cmbBillNumber_B != null) {
			List<Bill> billDetails = clientLogic.getAlBillDetails();
			if(billDetails.size() == 0) {
				cmbBillNumber_B.removeAllItems();
				cmbBillNumber_B.addItem(CommonConstants.PLEASE_SELECT);
			} else {
				cmbBillNumber_B.removeAllItems();
				cmbBillNumber_B.addItem(CommonConstants.PLEASE_SELECT);
				for(int i=0;i<billDetails.size();i++) {
					cmbBillNumber_B.addItem(billDetails.get(i).getBillId());
				}
			}
		}
		
		lblChequingAmount_A.setText("0.0");
		lblSavingAmount_A.setText("0.0");
		lblAccountBalanceValue_A.setText("0.0");
		
		txtDepositAmount_D.setText("0.0");
		txtDrawAmount_W.setText("0.0");
		txtTransferAmount_T.setText("0.0");
		
		lblBillTypeValue_B.setText("");
		lblBillAmountValue_B.setText("");
		
	}

}