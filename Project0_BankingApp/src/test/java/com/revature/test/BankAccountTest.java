package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.revature.bank.BankAccount;

public class BankAccountTest {

	@Test
	public void testDeposit() {
		BankAccount b = new BankAccount();
		b.setBalance(100);
		int actual = (int) b.getBalance();
		assertEquals(100, actual);
	}

	@Test
	public void testWithdraw() {
		BankAccount b = new BankAccount();
		b.setBalance(200);
		int actual = (int) b.getBalance();
		assertEquals(200, actual);
	}

	@Test
	public void testTransfer() {
		BankAccount a = new BankAccount();
		BankAccount b = new BankAccount();
		
		a.setBalance(400);
		b.setBalance(300);
		
		int firstActual = (int) a.getBalance();
		int secondActual = (int) b.getBalance();
		
		assertEquals(400, firstActual);
		assertEquals(300, secondActual);
	}

}
