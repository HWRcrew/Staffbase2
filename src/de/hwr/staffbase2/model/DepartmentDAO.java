package de.hwr.staffbase2.model;

import java.util.List;

/**
 * DAO zum Zugriff auf Daten eines Department
 * 
 * @author sebastiangrosse
 * 
 */
public interface DepartmentDAO {
	public void insert(Department department);

	public void update(Department department);

	public void delete(Department department);

	/**
	 * Findet alle Departments in einer Datenbank
	 * 
	 * @return List of Departments
	 */
	public List<Department> find();

	/**
	 * Findet ein Department in der Datenbank anhand seiner id
	 * 
	 * @param id
	 * @return
	 */
	public Department find(long id);
}
