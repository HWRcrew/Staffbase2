package de.hwr.staffbase2.model;

public interface Account {
	
	public long getId();

	public void setId(long id);

	public String getUsername();

	public void setUsername(String username);

	public String getPassword();

	public void setPassword(String password);

	public boolean isManager();

	public void setManager(boolean manager);

	public Employee getEmployee();

	public void setEmployee(Employee employee);
}
