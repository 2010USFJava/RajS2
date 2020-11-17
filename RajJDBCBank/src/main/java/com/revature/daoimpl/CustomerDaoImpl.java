package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.Customer;
import com.revature.dao.CustomerDao;
import com.revature.util.ConnectionFactory;
import com.revature.util.Log;

public class CustomerDaoImpl implements CustomerDao{
	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	
	@Override
	public void createNewCustomer(Customer c) throws SQLException { 
		Connection conn = cf.getConnection();
		String sql = "insert into customer values(default,default,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setString(3, c.getUsername());
		ps.setString(4, c.getPassword());
		ps.executeUpdate();	
		Log.LogIt("info", "Customer, " + c.getFirstName() + " " + c.getLastName() + ", was added.");
		System.out.println();
	}
	
	@Override
	public List<Customer> viewAllCustomers() throws SQLException {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = cf.getConnection();
		String sql = "select * from customer";
		PreparedStatement ps = conn.prepareStatement(sql);;
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			customerList.add(c);
		}
		return customerList;
	}

	@Override
	public boolean findCustomerByLogin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from customer where username=? and userpassword=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getString(5), rs.getString(6));
			BankAccountDaoImpl.currentBankID = rs.getInt(1);
			return true;
		}
		return false;
	}

	@Override
	public Customer findCustomerById(int currentBankID) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from customer where bank_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, currentBankID);
		ResultSet rs = ps.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			System.out.println(c);
		}
		return c;
	}

}
