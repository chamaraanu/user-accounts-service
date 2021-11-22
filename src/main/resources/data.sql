DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id INT PRIMARY KEY,
	username VARCHAR(25),
	firstname VARCHAR(25),
	lastname VARCHAR(25)
);

INSERT INTO users (id, username, firstname, lastname) VALUES 
	(1234673, 'eric421', 'Eric', 'Smith'),
	(6458789, 'david331', 'David', 'Brown'),
	(2342689, 'alex235','Alex', 'Vaughn');
	
DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
	account_number INT,
	user_id INT,
	PRIMARY KEY (account_number),
    FOREIGN KEY (user_id) REFERENCES users(id),
	account_name VARCHAR(50),
	account_type VARCHAR(25),
	balance_date DATE,
	currency VARCHAR(10),
	opening_available_balance FLOAT
);

INSERT INTO accounts (account_number, user_id, account_name, account_type, balance_date, currency, opening_available_balance) VALUES
	(120234536, 1234673, 'SGSavings726', 'Savings', DATE '2015-12-17', 'SGD', 123000.24),
	(650544556, 1234673, 'SGSavings726', 'Savings', DATE '2016-05-20', 'SGD', 500000.50),
	(998023452, 6458789, 'AUCurrent456', 'Current', DATE '2017-10-10', 'AUD', 1246000.24),
	(414267845, 2342689, 'USCurrent442', 'Current', DATE '2012-08-10', 'USD', 231634.57);
	
DROP TABLE IF EXISTS transactions;

CREATE TABLE transactions (
	transaction_number INT,
	transaction_account INT,
	PRIMARY KEY (transaction_number),
	FOREIGN KEY (transaction_account) REFERENCES accounts(account_number),
	value_date DATE,
	debit_amount FLOAT,
	credit_amount FLOAT,
	book_keeping VARCHAR(25),
	transaction_narrative VARCHAR(25)
);

INSERT INTO transactions (transaction_number, transaction_account, value_date, debit_amount, credit_amount, book_keeping, transaction_narrative) VALUES 
	(12316234, 120234536, DATE '2021-08-10', 0.00, 291.34, 'debit', 'telco payment'), 
	(49112312, 120234536, DATE '2021-08-11', 10000.00, 0.00, 'credit', 'salary');