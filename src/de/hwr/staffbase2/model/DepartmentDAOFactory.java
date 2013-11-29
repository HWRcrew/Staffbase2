package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.DepartmentDAOImpl;

/**
 * Factory zur Erzeugung eines DAO fuer Department-Objekte (bisher nur für Datenbanken)
 * 
 * @author sebastiangrosse
 * 
 */
public class DepartmentDAOFactory {
	private static DepartmentDAOFactory departmentDAOFactory = null;
	
	public DepartmentDAO getDepartmentDAO() {
		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		return departmentDAO;
	}
	
	public static DepartmentDAOFactory getInstance(){
		if(departmentDAOFactory == null){
			departmentDAOFactory = new DepartmentDAOFactory();
		}
		return departmentDAOFactory;
	}
}
