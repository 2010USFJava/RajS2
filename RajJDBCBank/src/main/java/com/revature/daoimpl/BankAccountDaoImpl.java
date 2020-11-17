package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.AdminActions;
import com.revature.bank.BankAccount;
import com.revature.bank.BankActions;
import com.revature.bank.Customer;
import com.revature.dao.BankAccountDao;
import com.revature.menu.Menu;
import com.revature.util.ConnectionFactory;
import com.revature.util.Log;

public class BankAccountDaoImpl implements BankAccountDao {
	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	public static int currentBankID;
	
	@Override
	public void createBankAccount(BankAccount b) throws SQLException { 
		Connection conn = cf.getConnection();
		String sql = "insert into bankaccount values(default,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, b.getBalance()); 
		ps.setString(2, b.getAccountType()); 
		ps.executeUpdate();		
		Log.LogIt("info", "Account with account ID, " + b.getAccountNumber() + ", has created an account");
		System.out.println();
	}
	
	@Override
	public int viewCurrentBankID() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select bank_account_id from bankaccount";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			currentBankID = rs.getInt(1);
		}
		return currentBankID;
	}

	@Override
	public BankAccount findAccountById(int currentBankID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentBankID);
		ResultSet rs = ps.executeQuery();
		BankAccount b = null;
		while(rs.next()) {
			b = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getString(3));
			System.out.println(b);
		}		
		return b;
	}
	
	@Override
	public List<BankAccount> viewAllAccounts() throws SQLException {
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		Connection conn = cf.getConnection();
		String sql = "select * from bankaccount";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		BankAccount b = null;
		while(rs.next()) {
			b = new BankAccount(rs.getInt(1), rs.getDouble(2), rs.getString(3));
			accountList.add(b);
			//System.out.println(b);
		}		
		return accountList;
	}

	@Override
	public double viewBalance(int currentBankID) throws SQLException { //gets balance from DB
		Connection conn = cf.getConnection();
		String sql = "select balance from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentBankID);
		ResultSet rs = ps.executeQuery();
		double balance = 0;
		while(rs.next()) {
			balance = rs.getDouble(1);
		}

		return balance;
	}

	@Override
	public void updateBalance(double newBalance, int currentBankID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update bankaccount set balance=? where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDouble(1, newBalance);
		ps.setInt(2, currentBankID);
		ps.executeUpdate();
	}

	@Override
	public void deposit() throws SQLException {
		double currentBalance = viewBalance(currentBankID); 
		double newBalance = BankActions.calculateDeposit(currentBalance); 
		updateBalance(newBalance, currentBankID);
		Log.LogIt("info", "Account with account ID, " + currentBankID+ " deposited into their account.");
		System.out.println();
	}

	@Override
	public void withdraw() throws SQLException {
		double currentBalance = viewBalance(currentBankID); 
		double newBalance = BankActions.calculateWithdraw(currentBalance); 
		updateBalance(newBalance,currentBankID);
		Log.LogIt("info", "Account with account ID, " + currentBankID+ " made a withdrawal.");
		System.out.println();
	}
	
	@Override
	public boolean isEmptyBalance() throws SQLException{
		double currentBalance = viewBalance(currentBankID);
		if( currentBalance == 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteIfEmpty() throws SQLException {
		if (isEmptyBalance()) {
			System.out.println("Would you like to delete this empty account?(y/n)");
			String response = Menu.sc.nextLine();
			if (response.equalsIgnoreCase("y")) {
				deleteAccount(currentBankID);
				Menu.mainMenu();
			} else {
				Menu.customerMenu();
			}
		} else {
			System.out.println("Account is not empty. You cannot delete unless account is empty.");
		}
	}

	@Override
	public void deleteAccount(int currentBankID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "delete from customer where bank_id=?; delete from bankaccount where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentBankID);
		ps.setInt(2, currentBankID);
		ps.executeUpdate();
		//System.out.println("This account has been deleted.\n");
		Log.LogIt("info", "Account with account ID, " + currentBankID+ " has been deleted.");
		System.out.println();
	}

}
