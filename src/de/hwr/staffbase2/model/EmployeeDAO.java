package de.hwr.staffbase2.model;

import java.util.List;

public interface EmployeeDAO {

	public void insert(Employee employee);

	public void update(Employee employee);

	public void delete(Employee employee);

	public List<Employee> find();

	public Employee find(long id);

	public Employee find(long id, Account account);
}
