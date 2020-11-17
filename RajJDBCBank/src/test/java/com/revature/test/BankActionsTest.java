package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.bank.BankAccount;
import com.revature.bank.BankActions;

public class BankActionsTest {
	BankAccount b = new BankAccount();
	
	@Test
	public void deposiTest() {
		//Mockito.when(BankActions.amount).thenReturn(500);
		b.setBalance(500);
		int actual = (int) BankActions.calculateDeposit(500);
		assertEquals(1000, actual);
	}

}
