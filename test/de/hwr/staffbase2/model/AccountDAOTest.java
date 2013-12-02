package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountDAOTest {
	@Test
	public void testInsert() {
		/*
		 * Account instanzieren
		 */
		Account account = AccountFactory.getInstance().getAccount();
		account.setManager(true);
		account.setPassword("passwort");
		account.setUsername("sebastiangrosse");
		/*
		 * Employee instanzieren
		 */
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		account.setEmployee(employee);
		employee.setAccount(account);
		employee.setPrename("Sebastian");
		employee.setSurname("Große");
		employee.setCity("Berlin");
		employee.setSalary(3000);
		employee.setStreet("Müllerstraße");
		employee.setZipcode(11027);
		/*
		 * DAO instanzieren
		 */
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		/*
		 * Vergleich anhand der Id
		 */
		assertEquals(accountDAO.find(account.getId()).getId(), account.getId());
		assertEquals(accountDAO.find(account.getId()).isManager(),
				account.isManager());
	}

	@Test
	public void testUpdate() {
		Account account = AccountFactory.getInstance().getAccount();
		account.setManager(true);
		account.setPassword("passwort");
		account.setUsername("sebastiangrosse");
		AccountDAO accountDAO = AccountDAOFactory.getInstance().getAccountDAO();
		accountDAO.insert(account);
		account.setUsername("leroyhöbold");
		account.setManager(false);
		accountDAO.update(account);
		assertEquals(accountDAO.find(account.getId()).getUsername(),
				"leroyhöbold");
		assertEquals(accountDAO.find(account.getId()).isManager(), false);

		// TODO testen
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindString() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

}
