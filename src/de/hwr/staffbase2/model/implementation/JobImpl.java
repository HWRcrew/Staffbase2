package de.hwr.staffbase2.model.implementation;

import de.hwr.staffbase2.model.IdFactory;
import de.hwr.staffbase2.model.Job;

public class JobImpl implements Job {

	private long id;
	private String name;
	private String description;
	private float salary;

	public JobImpl() {
		this.id = IdFactory.getInstance().generateID();
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public float getSalary() {
		return this.salary;
	}

	@Override
	public void setSalary(float salary) {
		this.salary = salary;
	}

}
