package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.EmployeeImpl;

/**
 * Factory zur Erzeugung eines Employee
 * 
 * @author sebastiangrosse
 * 
 */

public class EmployeeFactory {
	private static EmployeeFactory employeeFactory = null;

	public Employee getEmployee() {
		return new EmployeeImpl();
	}

	public static EmployeeFactory getInstance() {
		if (employeeFactory == null) {
			employeeFactory = new EmployeeFactory();
		}
		return employeeFactory;
	}
}
