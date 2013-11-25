package de.hwr.staffbase2.model.implementation;

import de.hwr.staffbase2.model.Account;
import de.hwr.staffbase2.model.Employee;
import de.hwr.staffbase2.model.IdFactory;

public class AccountImpl implements Account {
	private long id;
	private String username;
	private String password;
	private boolean manager;
	private Employee employee = null;

	public AccountImpl() {
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
	public String getUsername() {
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isManager() {
		return this.manager;
	}

	@Override
	public void setManager(boolean manager) {
		this.manager = manager;
	}

	@Override
	public Employee getEmployee() {
		return this.employee;
	}

	@Override
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
