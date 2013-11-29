package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.DepartmentImpl;

/**
 * Factory zur Erzeugung eines Department
 * 
 * @author sebastiangrosse
 * 
 */
public class DepartmentFactory {
	private static DepartmentFactory departmentFactory = null;

	public Department getDepartment() {
		return new DepartmentImpl();
	}

	public static DepartmentFactory getInstance() {
		if (departmentFactory == null) {
			departmentFactory = new DepartmentFactory();
		}
		return departmentFactory;
	}
}
