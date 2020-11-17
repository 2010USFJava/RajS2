package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bank.Admin;
import com.revature.bank.BankAccount;
import com.revature.bank.Customer;
import com.revature.dao.AdminDao;
import com.revature.menu.Menu;
import com.revature.util.ConnectionFactory;
import com.revature.util.Log;

public class AdminDaoImpl implements AdminDao{
	public static ConnectionFactory cf = ConnectionFactory.getInstance();
	
	@Override
	public boolean findAdminByLogin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from admin where username=? and adminpassword=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Admin a = null;
		while(rs.next()) {
			a = new Admin(rs.getString(4), rs.getString(5));
			BankAccountDaoImpl.currentBankID = rs.getInt(1);
			return true;
		}
		return false;
	}

	@Override
	public void editAllCustomerInfo(Customer c) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update customer set firstname=?, lastname=?, username=?, userpassword=? where bank_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		Customer updatedC = Menu.updateCustomerInfoMenu(c);
		
		ps.setString(1, updatedC.getFirstName());
		ps.setString(2, updatedC.getLastName());
		ps.setString(3, updatedC.getUsername());
		ps.setString(4, updatedC.getPassword());
		ps.setInt(5, BankAccountDaoImpl.currentBankID);
		ps.executeUpdate();
	}

	@Override
	public void editAllAccountInfo(BankAccount b) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update bankaccount set balance=?, accountType=? where bank_account_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		BankAccount updatedB = Menu.updateAccountInfoMenu(b);
		
		ps.setDouble(1, updatedB.getBalance());
		ps.setString(2, updatedB.getAccountType());
		ps.setInt(3, BankAccountDaoImpl.currentBankID);
		ps.executeUpdate();
	}

}
