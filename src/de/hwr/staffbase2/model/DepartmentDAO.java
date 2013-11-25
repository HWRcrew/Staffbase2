package de.hwr.staffbase2.model;

import java.util.List;

public interface DepartmentDAO {
	public void insert(Department department);

	public void update(Department department);

	public void delete(Department department);

	public List<Department> find();

	public Department find(long id);
}
