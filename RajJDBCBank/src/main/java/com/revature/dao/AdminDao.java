package com.revature.dao;

import java.sql.SQLException;

import com.revature.bank.BankAccount;
import com.revature.bank.Customer;

public interface AdminDao {
	public boolean findAdminByLogin(String username, String password) throws SQLException;
	
	public void editAllCustomerInfo(Customer c) throws SQLException;
	
	public void editAllAccountInfo(BankAccount b) throws SQLException;

}
