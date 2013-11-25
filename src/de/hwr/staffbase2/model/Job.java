package de.hwr.staffbase2.model;

public interface Job {
	public long getId();

	public void setId(long id);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public float getSalary();

	public void setSalary(float salary);
}
