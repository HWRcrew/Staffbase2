package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.AccountImpl;

public class AccountFactory {
	
	private static AccountFactory accountFactory = null;
	
	public Account getAccount() {
		return new AccountImpl();
	}
	
	public static AccountFactory getInstance(){
		if (accountFactory == null){
			accountFactory = new AccountFactory();
		}
		return accountFactory;
	}
}
