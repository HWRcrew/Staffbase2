package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.EmployeeDAOImpl;

public class EmployeeDAOFactory {
	private static EmployeeDAOFactory employeeDAOFactory = null;

	public EmployeeDAO getEmployeeDAO() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		return employeeDAO;
	}

	public static EmployeeDAOFactory getInstance() {
		if (employeeDAOFactory == null) {
			employeeDAOFactory = new EmployeeDAOFactory();
		}
		return employeeDAOFactory;
	}
}
