package de.hwr.staffbase2.model.implementation;

import de.hwr.staffbase2.model.Department;
import de.hwr.staffbase2.model.IdFactory;

public class DepartmentImpl implements Department {

	private long id;
	private String name;
	private String description;

	public DepartmentImpl() {
		this.id = IdFactory.getInstance().generateID();
	}

	@Override
	public long getId() {
		return this.id;
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

}
