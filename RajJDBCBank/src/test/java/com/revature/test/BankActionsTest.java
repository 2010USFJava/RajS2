package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.mockito.Mockito;

import com.revature.bank.BankAccount;
import com.revature.bank.BankActions;

public class BankActionsTest {
	BankAccount b = new BankAccount();
	
	@Test
	public void depositTest() {
		Double actual = BankActions.calculateDeposit(500.0);
		System.out.println(actual);
		assertEquals((Double)600.0, actual);
	}
	
	@Test
	public void withdrawTest() {
		Double actual = BankActions.calculateWithdraw(500.0);
		System.out.println(actual);
		assertEquals((Double)400.0, actual);
	}
}
