package de.hwr.staffbase2.model;

import java.util.List;

/**
 * DAO zum Zugriff auf Employee-Daten in der Persistenzschicht
 * 
 * @author sebastiangrosse
 * 
 */
public interface EmployeeDAO {

	/**
	 * Fuegt einen Employee in die Datenbank ein.
	 * @param employee
	 */
	public void insert(Employee employee);

	/**
	 * Aktualisiert die Daten des Employee ueber ein Update-Statement
	 * @param employee
	 */
	public void update(Employee employee);

	/**
	 * Löscht den uebergebenen Employee anhand seiner id
	 * @param employee
	 */
	public void delete(Employee employee);

	/**
	 * Findet alle Employee die erfasst sind.
	 * @return List of Employee
	 */
	public List<Employee> find();

	/**
	 * Der Employee wird anhand seine id gefunden
	 * @param id
	 * @return Employee
	 */
	public Employee find(long id);

	/**
	 * Es wird der Employee anhand seiner id gefunden und ihm wird der
	 * uebergebene Account gesetzt
	 * 
	 * @param id
	 * @param account
	 * @return Employee
	 */
	public Employee find(long id, Account account);
}
