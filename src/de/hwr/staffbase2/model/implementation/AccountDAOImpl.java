package de.hwr.staffbase2.model.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hwr.staffbase2.model.Account;
import de.hwr.staffbase2.model.AccountDAO;
import de.hwr.staffbase2.model.AccountFactory;
import de.hwr.staffbase2.model.ConnectionFactory;
import de.hwr.staffbase2.model.Employee;
import de.hwr.staffbase2.model.EmployeeDAO;
import de.hwr.staffbase2.model.EmployeeDAOFactory;

public class AccountDAOImpl implements AccountDAO {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insert(Account account) {
		try {
			String queryString = "INSERT INTO account(id, username, password, manager, fk_employee) VALUES(?,?,md5(?),?,?);";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, account.getId());
			preparedStatement.setString(2, account.getUsername());
			preparedStatement.setString(3, account.getPassword());
			preparedStatement.setBoolean(4, account.isManager());
			if (account.getEmployee() != null) {
				preparedStatement.setLong(5, account.getEmployee().getId());
			} else {
				preparedStatement.setLong(5, 0);
			}
			preparedStatement.executeUpdate();
			System.out.println("Insert complete!");
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
	public void update(Account account) {
		try {
			String queryString = "UPDATE account SET username=?, password=md5(?), manager=?, fk_employee=? WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, account.getUsername());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setBoolean(3, account.isManager());
			if (account.getEmployee() != null) {
				preparedStatement.setLong(4, account.getEmployee().getId());
			} else {
				preparedStatement.setLong(4, 0);
			}
			preparedStatement.setLong(5, account.getId());
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
	public void delete(Account account) {
		String queryString = "DELETE FROM account WHERE id=?;";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, account.getId());
			preparedStatement.executeUpdate();
			System.out.println("Remove of Account with username: "
					+ account.getUsername() + " and id: " + account.getId()
					+ " complete! Employee has to be removed separately.");
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
	public Account find(String username, String password) {
		try {
			String queryString = "SELECT * FROM account WHERE username=? AND password=md5(?);";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				return find(username);
			} else {
				return null;
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
	public Account find(String username) {
		try {
			String queryString = "SELECT * FROM account WHERE username=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				Account account = AccountFactory.getInstance().getAccount();
				account.setId(resultSet.getLong("id"));
				account.setUsername(resultSet.getString("username"));
				account.setPassword(resultSet.getString("password"));
				account.setManager(resultSet.getBoolean("manager"));
				if (resultSet.getLong("fk_employee") != 0) {
					EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
							.getEmployeeDAO();
					Employee employee = employeeDAO.find(
							resultSet.getLong("fk_employee"), account);
					account.setEmployee(employee);
				}
				return account;
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
	public Account find(long id) {
		try {
			String queryString = "SELECT * FROM account WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				Account account = AccountFactory.getInstance().getAccount();
				account.setId(id);
				account.setUsername(resultSet.getString("username"));
				account.setPassword(resultSet.getString("password"));
				account.setManager(resultSet.getBoolean("manager"));
				if (resultSet.getLong("fk_employee") != 0) {
					EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
							.getEmployeeDAO();
					Employee employee = employeeDAO.find(
							resultSet.getLong("fk_employee"), account);
					account.setEmployee(employee);
				}
				return account;
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
	public List<Account> find() {
		List<Account> accounts = new ArrayList<Account>();
		try {
			String queryString = "SELECT * FROM account";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Account account = AccountFactory.getInstance().getAccount();
				account.setId(resultSet.getLong("id"));
				account.setUsername(resultSet.getString("username"));
				account.setPassword(resultSet.getString("password"));
				account.setManager(resultSet.getBoolean("manager"));
				if (resultSet.getInt("fk_employee") != 0) {
					EmployeeDAO employeeDAO = EmployeeDAOFactory.getInstance()
							.getEmployeeDAO();
					Employee employee = employeeDAO.find(resultSet
							.getInt("fk_employee"));
					account.setEmployee(employee);
				}
				accounts.add(account);
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
		return accounts;
	}

}
