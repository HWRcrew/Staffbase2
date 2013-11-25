package de.hwr.staffbase2.model;

public interface Employee {
	public long getId();

	public void setId(long id);

	public String getSurname();

	public void setSurname(String surname);

	public String getPrename();

	public void setPrename(String prename);

	public String getStreet();

	public void setStreet(String street);

	public int getZipcode();

	public void setZipcode(int zipcode);

	public String getCity();

	public void setCity(String city);

	public float getSalary();

	public void setSalary(float salary);

	public Account getAccount();

	public void setAccount(Account account);

	public Department getDepartment();

	public void setDepartment(Department department);

	public Job getJob();

	public void setJob(Job job);
}
