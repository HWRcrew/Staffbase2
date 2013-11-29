package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.AccountDAOImpl;

/**
 * Factory zur Erzeugung eines DAO fuer Account-Objekte (bisher nur für Datenbanken)
 * 
 * @author sebastiangrosse
 * 
 */
public class AccountDAOFactory {
	private static AccountDAOFactory accountDAOFactory = null;

	public AccountDAO getAccountDAO() {
		AccountDAO accountDAO = new AccountDAOImpl();
		return accountDAO;
	}

	public static AccountDAOFactory getInstance() {
		if (accountDAOFactory == null) {
			accountDAOFactory = new AccountDAOFactory();
		}
		return accountDAOFactory;
	}
}
