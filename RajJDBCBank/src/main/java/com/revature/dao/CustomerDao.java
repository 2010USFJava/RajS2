package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bank.BankAccount;
import com.revature.bank.Customer;

public interface CustomerDao {

	public void createNewCustomer(Customer c) throws SQLException;

	public boolean findCustomerByLogin(String username, String password) throws SQLException;
	
	public List<Customer> viewAllCustomers() throws SQLException;
	
	public Customer findCustomerById(int currentBankID) throws SQLException;
	
}
