package de.hwr.staffbase2.model.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hwr.staffbase2.model.ConnectionFactory;
import de.hwr.staffbase2.model.Department;
import de.hwr.staffbase2.model.DepartmentDAO;
import de.hwr.staffbase2.model.DepartmentFactory;

public class DepartmentDAOImpl implements DepartmentDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insert(Department department) {
		try {
			String queryString = "INSERT INTO department(id, name, description) VALUES(?,?,?);";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, department.getId());
			preparedStatement.setString(2, department.getName());
			preparedStatement.setString(3, department.getDescription());
			preparedStatement.executeUpdate();
			System.out.println("Insert of department with ID = " + department.getId()
					+ " complete!");
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
	public void update(Department department) {
		try {
			String queryString = "UPDATE department SET name=?, description=? WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, department.getName());
			preparedStatement.setString(2, department.getDescription());
			preparedStatement.setLong(3, department.getId());
			preparedStatement.executeUpdate();
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
	public void delete(Department department) {
		String queryString = "DELETE FROM department WHERE id=?;";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, department.getId());
			preparedStatement.executeUpdate();
			System.out.println("Remove of Department with name: "
					+ department.getName() + " and id: " + department.getId()
					+ " complete!");
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
	public List<Department> find() {
		List<Department> departments = new ArrayList<Department>();
		try {
			String queryString = "SELECT * FROM department";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Department department = DepartmentFactory.getInstance().getDepartment();
				department.setId(resultSet.getLong("id"));
				department.setName(resultSet.getString("name"));
				department.setDescription(resultSet.getString("description"));
				departments.add(department);
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
		return departments;
	}

	@Override
	public Department find(long id) {
		try {
			String queryString = "SELECT * FROM department WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Department department = DepartmentFactory.getInstance()
						.getDepartment();
				department.setId(id);
				department.setName(resultSet.getString("name"));
				department.setDescription(resultSet.getString("description"));
				return department;
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
