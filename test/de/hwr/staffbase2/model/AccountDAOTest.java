package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

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
		account.setUsername("sebastiangrosse");
		// DAO instanzieren
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		// Test
		assertEquals(account.isManager(), accountDAO.find(account.getId())
				.isManager());
		assertEquals(account.getUsername(), accountDAO.find(account.getId())
				.getUsername());
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
		assertNotNull(accountDAO.find(account.getUsername(), account.getPassword()));
		accountDAO.delete(account);
	}

	@Test
	public void testInsertAndFindByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertAndFindAll() {
		
		fail("Not yet implemented");
	}

}
