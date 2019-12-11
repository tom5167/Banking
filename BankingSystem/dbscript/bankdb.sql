DROP TABLE IF EXISTS `tbl_account_balance`;
CREATE TABLE `tbl_account_balance` (
  `balance_id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `client_id` int(10) NOT NULL,
  `acc_no` varchar(30) NOT NULL,
  `c_balance` double(16,2) NOT NULL,
  `s_balance` double(16,2) NOT NULL,
  `last_update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO `tbl_account_balance`(CLIENT_ID,ACC_NO,C_BALANCE,S_BALANCE) 
VALUES (1,'DBC001',2000.00,7000.00);
INSERT INTO `tbl_account_balance`(CLIENT_ID,ACC_NO,C_BALANCE,S_BALANCE) 
VALUES (1,'DBC002',590.00,500.00);

DROP TABLE IF EXISTS `tbl_client`;
CREATE TABLE `tbl_client` (
  `client_user_id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `client_user_name` varchar(40) NOT NULL,
  `client_user_password` varchar(30) NOT NULL,
  `client_f_name` varchar(30) NOT NULL,
  `client_l_name` varchar(30) NOT NULL,
  `client_dob` varchar(30) NOT NULL,
  `client_sex` varchar(30) NOT NULL,
  `client_address` varchar(30) NOT NULL,
  `client_zip_code` varchar(30) NOT NULL,
  `client_email` varchar(30) NOT NULL,
  `client_phone_no` varchar(30) NOT NULL,
  `created_user_id` int(10) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO `tbl_client`(client_user_name,client_user_password,client_f_name,client_l_name,
client_dob,client_sex,client_address,client_zip_code,client_email,client_phone_no,created_user_id)
VALUES ('alex123','qwe@123','Jon','Alex',
'1993-10-02','Male','33 Village green square','M1B1A3','alex@gmail.com','6475492785',0);

DROP TABLE IF EXISTS `tbl_transaction`;
CREATE TABLE `tbl_transaction` (
  `transaction_id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `acc_no` varchar(30) NOT NULL,
  `amount` double(16,2) NOT NULL,
  `is_debit` varchar(30) NOT NULL,
  `is_credit` varchar(30) NOT NULL,
  `is_transfer` varchar(30) NOT NULL,
  `transaction_date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS `tbl_bill`;
CREATE TABLE `tbl_bill` (
  `bill_id` int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `bill_type` varchar(20) NOT NULL,
  `bill_amount` double(16,2) NOT NULL,
  `is_payed` varchar(20) NOT NULL,
  `bill_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO `tbl_bill`(client_id,bill_type,bill_amount,is_payed)
VALUES (1,'Phone',100.00,'No');
INSERT INTO `tbl_bill`(client_id,bill_type,bill_amount,is_payed)
VALUES (1,'Hydro',100.00,'No');
INSERT INTO `tbl_bill`(client_id,bill_type,bill_amount,is_payed)
VALUES (1,'Cable',100.00,'No');