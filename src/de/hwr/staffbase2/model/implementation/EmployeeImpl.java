package de.hwr.staffbase2.model.implementation;

import de.hwr.staffbase2.model.Account;
import de.hwr.staffbase2.model.Department;
import de.hwr.staffbase2.model.Employee;
import de.hwr.staffbase2.model.IdFactory;
import de.hwr.staffbase2.model.Job;

public class EmployeeImpl implements Employee {
	private long id;
	private String surname;
	private String prename;
	private String street;
	private int zipcode;
	private String city;
	private float salary;
	private Account account;
	private Department department;
	private Job job;

	public EmployeeImpl() {
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
	public String getSurname() {
		return this.surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String getPrename() {
		return this.prename;
	}

	@Override
	public void setPrename(String prename) {
		this.prename = prename;
	}

	@Override
	public String getStreet() {
		return this.street;
	}

	@Override
	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public int getZipcode() {
		return this.zipcode;
	}

	@Override
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String getCity() {
		return this.city;
	}

	@Override
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public float getSalary() {
		return this.salary;
	}

	@Override
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public Account getAccount() {
		return this.account;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public Department getDepartment() {
		return this.department;
	}

	@Override
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public Job getJob() {
		return this.job;
	}

	@Override
	public void setJob(Job job) {
		this.job = job;
	}
}
