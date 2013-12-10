package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * Test fuer AccountDAO
 * 
 * @author sebastiangrosse
 * 
 */
public class AccountDAOTest {
	@Test
	public void testInsertAndFindById() {
		// Account instanzieren
		Account account = AccountFactory.getInstance().getAccount();
		account.setManager(true);
		account.setPassword("passwort");
		account.setUsername("sebastiangrosses");
		// DAO instanzieren
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		// Test
		assertEquals(account.isManager(), accountDAO.find(account.getId())
				.isManager());
		assertEquals(account.getUsername(), accountDAO.find(account.getId())
				.getUsername());
		accountDAO.delete(account);
	}

	@Test
	public void testUpdate() {
		Account account = AccountFactory.getInstance().getAccount();
		account.setManager(true);
		account.setPassword("passwort");
		account.setUsername("sebastiangrosse");
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		// insert
		accountDAO.insert(account);
		account.setUsername("leroyhöbold");
		account.setManager(false);
		// update
		accountDAO.update(account);
		// test
		assertEquals("leroyhöbold", accountDAO.find(account.getId())
				.getUsername());
		assertEquals(false, accountDAO.find(account.getId()).isManager());
		accountDAO.delete(account);
	}

	@Test
	public void testDelete() {
		Account account = AccountFactory.getInstance().getAccount();
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		// Insert
		accountDAO.insert(account);
		// Delete
		accountDAO.delete(account);
		// Test ob in DB vorhanden
		assertNull(accountDAO.find(account.getId()));
	}

	@Test
	public void testFindByUsernameAndPassword() {
		Account account = AccountFactory.getInstance().getAccount();
		account.setUsername("sebastian123");
		account.setPassword("testpassword");
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		// Test ob in DB vorhanden
		assertNotNull(accountDAO.find(account.getUsername(),
				account.getPassword()));
		accountDAO.delete(account);
	}

	@Test
	public void testInsertAndFindByUsername() {
		Account account = AccountFactory.getInstance().getAccount();
		account.setUsername("sebastian123");
		account.setPassword("testpassword");
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		// Test ob in DB vorhanden
		assertNotNull(accountDAO.find(account.getUsername()));
		accountDAO.delete(account);
	}

	@Test
	public void testInsertAndFindAll() {
		Account account = AccountFactory.getInstance().getAccount();
		account.setUsername("sebastian123");
		account.setPassword("testpassword");
		Account account2 = AccountFactory.getInstance().getAccount();
		account2.setUsername("sebastian1234");
		account2.setPassword("testpassword2");
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		accountDAO.insert(account2);
		List<Account> accounts = accountDAO.find();
		boolean test = false;
		boolean test2 = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getId() == account.getId()) {
				test = true;
			}
			if (accounts.get(i).getId() == account2.getId()) {
				test2 = true;
			}
		}
		accountDAO.delete(account);
		accountDAO.delete(account2);
		assertTrue(test);
		assertTrue(test2);
	}

}
