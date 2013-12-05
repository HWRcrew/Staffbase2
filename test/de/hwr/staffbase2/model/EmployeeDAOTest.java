package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeDAOTest {

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindLong() {
		Employee employee = EmployeeFactory.getInstance().getEmployee();
		employee.setPrename("Harald");
		employee.setSurname("Müller");
		employee.setSalary(3000);
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance().getEmployeeDAO();
		employeeDAO.insert(employee);
		employeeDAO.find(employee.getId()).toString();
		fail("Not yet implemented");
	}

	@Test
	public void testFindLongAccount() {
		fail("Not yet implemented");
	}

}
