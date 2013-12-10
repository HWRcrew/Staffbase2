package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class EmployeeDAOTest {

	@Test
	public void testInsertAndFindById() {
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		employee.setPrename("Harald");
		employee.setSurname("Müller");
		employee.setSalary(3000);
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
				.getEmployeeDAO();
		employeeDAO.insert(employee);
		// Findet Employee und vergleicht den Vornamen und Nachnamen
		assertEquals(employee.getPrename(), employeeDAO.find(employee.getId())
				.getPrename());
		assertEquals(employee.getSurname(), employeeDAO.find(employee.getId())
				.getSurname());
		//employeeDAO.delete(employee);
	}

	@Test
	public void testUpdate() {
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		employee.setPrename("Harald");
		employee.setSurname("Müller");
		employee.setSalary(3000);
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
				.getEmployeeDAO();
		employeeDAO.insert(employee);

		employee.setPrename("Günther");
		employee.setSurname("Grün");
		employeeDAO.update(employee);
		// Findet Employee und vergleicht den Vornamen und Nachnamen
		assertEquals(employee.getPrename(), employeeDAO.find(employee.getId())
				.getPrename());
		assertEquals(employee.getSurname(), employeeDAO.find(employee.getId())
				.getSurname());
		//employeeDAO.delete(employee);
	}

	
	public void testDelete() {
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		employee.setPrename("Harald");
		employee.setSurname("Müller");
		employee.setSalary(3000);
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
				.getEmployeeDAO();
		employeeDAO.insert(employee);
		employeeDAO.delete(employee);
		assertNull(employeeDAO.find(employee.getId()));
	}

	@Test
	public void testInsertAndFindAll() {
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
				.getEmployeeDAO();
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		employee.setPrename("Hans");
		employee.setSalary(4125);
		System.out.println(employee.getId());
		Employee employee2 = EmployeeFactory.getInstance().getEmployee();
		employee2.setPrename("Günther");
		employee2.setSalary(3400);
		System.out.println(employee2.getId());
		employeeDAO.insert(employee);
		employeeDAO.insert(employee2);
		List<Employee> employees = employeeDAO.find();
		// Teste ob Job mit id in der Liste ist
		boolean test = false;
		boolean test2 = false;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId() == employee.getId()) {
				test = true;
			}
			if (employees.get(i).getId() == employee2.getId()) {
				test2 = true;
			}
		}
		employeeDAO.delete(employee);
		employeeDAO.delete(employee2);
		assertTrue(test);
		assertTrue(test2);
	}

	@Test
	public void testFindLongAccount() {
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		employee.setPrename("Harald");
		employee.setSurname("Müller");
		employee.setSalary(3000);
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
				.getEmployeeDAO();
		employeeDAO.insert(employee);
		// Account instanzieren
		Account account = AccountFactory.getInstance().getAccount();
		account.setUsername("testuser");
		account.setManager(false);
		Employee employee2 = employeeDAO.find(employee.getId(), account);
		// Teste ob, account an gefundenem Employee den richtigen Username
		// besitzt.
		assertEquals(account.getUsername(), employee2.getAccount()
				.getUsername());
		// Findet Employee und vergleicht den Vornamen und Nachnamen
		//employeeDAO.delete(employee);
	}

}
