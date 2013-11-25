package de.hwr.staffbase2.model;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class AccountDAOTest {

	@Test
	public void testInsert() {
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		AccountFactory.getInstance();
		Account account = AccountFactory.getAccount();
		account.setManager(true);
		account.setPassword("test");
		account.setUsername("sebastian");
		// TODO Employee setzen zum Test.
		accountDAO.insert(account);
		List<Account> accounts = accountDAO.find();
		System.out.println(accounts.toString());
		fail();
	}
}
