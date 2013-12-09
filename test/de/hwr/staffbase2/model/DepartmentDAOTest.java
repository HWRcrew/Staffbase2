package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DepartmentDAOTest {

	@Test
	public void testInsertAndFindById() {
		Department department = DepartmentFactory.getInstance().getDepartment();
		department.setName("Entwicklung");
		department.setDescription("Abteilung der Entwickler.");
		DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance()
				.getDepartmentDAO();
		departmentDAO.insert(department);
		assertEquals("Entwicklung", departmentDAO.find(department.getId())
				.getName());
		assertEquals("Abteilung der Entwickler.",
				departmentDAO.find(department.getId()).getDescription());
	}

	@Test
	public void testUpdate() {
		Department department = DepartmentFactory.getInstance().getDepartment();
		department.setName("Entwicklung");
		department.setDescription("Abteilung der Entwickler.");
		DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance()
				.getDepartmentDAO();
		departmentDAO.insert(department);
		department.setDescription("Abteilung der Developer!");
		department.setName("Development");
		departmentDAO.update(department);
		assertEquals("Development", departmentDAO.find(department.getId())
				.getName());
		assertEquals("Abteilung der Developer!",
				departmentDAO.find(department.getId()).getDescription());
	}

	@Test
	public void testDelete() {
		Department department = DepartmentFactory.getInstance().getDepartment();
		DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance()
				.getDepartmentDAO();
		departmentDAO.insert(department);
		departmentDAO.delete(department);
		assertNull(departmentDAO.find(department.getId()));
	}

	@Test
	public void testInserFindAll() {
		DepartmentDAO departmentDAO = DepartmentDAOFactory.getInstance()
				.getDepartmentDAO();
		Department department = DepartmentFactory.getInstance().getDepartment();
		department.setName("Entwicklung");
		departmentDAO.insert(department);
		List<Department> departments = departmentDAO.find();
		// Teste ob Department mit id in der Liste ist
		boolean test = false;
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getId() == department.getId()) {
				test = true;
			}
		}
		assertTrue(test);
	}
}
