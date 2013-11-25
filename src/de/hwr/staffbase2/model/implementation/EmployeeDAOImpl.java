package de.hwr.staffbase2.model.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hwr.staffbase2.model.Account;
import de.hwr.staffbase2.model.AccountDAO;
import de.hwr.staffbase2.model.AccountDAOFactory;
import de.hwr.staffbase2.model.ConnectionFactory;
import de.hwr.staffbase2.model.DepartmentDAO;
import de.hwr.staffbase2.model.DepartmentDAOFactory;
import de.hwr.staffbase2.model.Employee;
import de.hwr.staffbase2.model.EmployeeDAO;
import de.hwr.staffbase2.model.EmployeeFactory;
import de.hwr.staffbase2.model.JobDAO;
import de.hwr.staffbase2.model.JobDAOFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insert(Employee employee) {
		try {
			String queryString = "INSERT INTO employee(id, prename, surname, street, zipcode, city, salary, fk_job, fk_department, fk_account) VALUES(?,?,?,?,?,?,?,?,?,?);";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, employee.getId());
			preparedStatement.setString(2, employee.getPrename());
			preparedStatement.setString(3, employee.getSurname());
			preparedStatement.setString(4, employee.getStreet());
			preparedStatement.setInt(5, employee.getZipcode());
			preparedStatement.setString(6, employee.getCity());
			preparedStatement.setFloat(7, employee.getSalary());
			if (employee.getJob() != null) {
				preparedStatement.setLong(8, employee.getJob().getId());
			} else {
				preparedStatement.setLong(8, 0);
			}
			if (employee.getDepartment() != null) {
				preparedStatement.setLong(9, employee.getDepartment().getId());
			} else {
				preparedStatement.setLong(9, 0);
			}
			if (employee.getAccount() != null) {
				preparedStatement.setLong(10, employee.getAccount().getId());
			} else {
				preparedStatement.setLong(10, 0);
			}
			preparedStatement.executeUpdate();
			System.out.println("Insert of Account complete!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Employee employee) {
		try {
			String queryString = "UPDATE employee SET prename=?, surname=?, street=?, zipcode=?, city=?, salary=?, fk_job=?, fk_department=?, fk_account=? WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, employee.getPrename());
			preparedStatement.setString(2, employee.getSurname());
			preparedStatement.setString(3, employee.getStreet());
			preparedStatement.setInt(4, employee.getZipcode());
			preparedStatement.setString(5, employee.getCity());
			preparedStatement.setFloat(6, employee.getSalary());
			if (employee.getJob() != null) {
				preparedStatement.setLong(7, employee.getJob().getId());
			} else {
				preparedStatement.setLong(7, 0);
			}
			if (employee.getDepartment() != null) {
				preparedStatement.setLong(8, employee.getDepartment().getId());
			} else {
				preparedStatement.setLong(8, 0);
			}
			if (employee.getAccount() != null) {
				preparedStatement.setLong(9, employee.getAccount().getId());
			} else {
				preparedStatement.setLong(9, 0);
			}
			preparedStatement.setLong(10, employee.getId());
			preparedStatement.executeUpdate();
			System.out.println("Update of Account complete!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(Employee employee) {
		String queryString = "DELETE FROM employee WHERE id=?;";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, employee.getId());
			preparedStatement.executeUpdate();
			System.out.println("Remove of Employee " + employee.getSurname()
					+ ", " + employee.getPrename() + " (id = "
					+ employee.getId()
					+ ") complete! Account has to be removed separately.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Employee> find() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			String queryString = "SELECT * FROM employee;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = EmployeeFactory.getInstance().getEmployee();
				employee.setId(resultSet.getLong("id"));
				employee.setPrename(resultSet.getString("prename"));
				employee.setSurname(resultSet.getString("surname"));
				employee.setStreet(resultSet.getString("street"));
				employee.setZipcode(resultSet.getInt("zipcode"));
				employee.setCity(resultSet.getString("city"));
				employee.setSalary(resultSet.getFloat("salary"));
				long jobId = resultSet.getLong("fk_job");
				if (jobId != 0) {
					JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
					employee.setJob(jobDAO.find(jobId));
				} else {
					employee.setJob(null);
				}
				long departmentId = resultSet.getLong("fk_department");
				if (departmentId != 0) {
					DepartmentDAO departmentDAO = DepartmentDAOFactory
							.getInstance().getDepartmentDAO();
					employee.setDepartment(departmentDAO.find(departmentId));
				} else {
					employee.setDepartment(null);
				}
				long accountId = resultSet.getLong("fk_account");
				if (accountId != 0) {
					AccountDAO accountDAO = AccountDAOFactory.getInstance()
							.getAccountDAO();
					employee.setAccount(accountDAO.find(accountId));
				}
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	@Override
	public Employee find(long id) {
		try {
			String queryString = "SELECT * FROM employee WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				EmployeeFactory.getInstance();
				Employee employee = EmployeeFactory.getInstance().getEmployee();
				employee.setId(resultSet.getLong("id"));
				employee.setPrename(resultSet.getString("prename"));
				employee.setSurname(resultSet.getString("surname"));
				employee.setStreet(resultSet.getString("street"));
				employee.setZipcode(resultSet.getInt("zipcode"));
				employee.setCity(resultSet.getString("city"));
				employee.setSalary(resultSet.getFloat("salary"));
				long jobId = resultSet.getLong("fk_job");
				if (jobId != 0) {
					JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
					employee.setJob(jobDAO.find(jobId));
				} else {
					employee.setJob(null);
				}
				long departmentId = resultSet.getLong("fk_department");
				if (departmentId != 0) {
					DepartmentDAO departmentDAO = DepartmentDAOFactory
							.getInstance().getDepartmentDAO();
					employee.setDepartment(departmentDAO.find(departmentId));
				} else {
					employee.setDepartment(null);
				}
				long accountId = resultSet.getLong("fk_account");
				if (accountId != 0) {
					AccountDAO accountDAO = AccountDAOFactory.getInstance()
							.getAccountDAO();
					employee.setAccount(accountDAO.find(accountId));
				}
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Employee find(long id, Account account) {
		try {
			String queryString = "SELECT * FROM employee WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null) {
				Employee employee = EmployeeFactory.getInstance().getEmployee();
				employee.setId(resultSet.getLong("id"));
				employee.setPrename(resultSet.getString("prename"));
				employee.setSurname(resultSet.getString("surname"));
				employee.setStreet(resultSet.getString("street"));
				employee.setZipcode(resultSet.getInt("zipcode"));
				employee.setCity(resultSet.getString("city"));
				employee.setSalary(resultSet.getFloat("salary"));
				long jobId = resultSet.getLong("fk_job");
				if (jobId != 0) {
					JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
					employee.setJob(jobDAO.find(jobId));
				} else {
					employee.setJob(null);
				}
				long departmentId = resultSet.getLong("fk_department");
				if (departmentId != 0) {
					DepartmentDAO departmentDAO = DepartmentDAOFactory
							.getInstance().getDepartmentDAO();
					employee.setDepartment(departmentDAO.find(departmentId));
				} else {
					employee.setDepartment(null);
				}
				employee.setAccount(account);
				return employee;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
