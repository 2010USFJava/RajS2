package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bank.BankAccount;

public interface BankAccountDao {
	public void createBankAccount(BankAccount b) throws SQLException;
	
	public int viewCurrentBankID() throws SQLException;
	
	//view existing accounts & balances
	public BankAccount findAccountById(int currentBankID) throws SQLException;
	
	public List<BankAccount> viewAllAccounts() throws SQLException;
	
	public double viewBalance(int currentBankID) throws SQLException;
	
	public void updateBalance(double newBalance, int currentBankID) throws SQLException;
	
	public void deposit() throws SQLException;
	
	public void withdraw() throws SQLException;
	
	public boolean isEmptyBalance() throws SQLException;
	
	public void deleteIfEmpty() throws SQLException;
	
	public void deleteAccount(int currentBankID) throws SQLException;

}
