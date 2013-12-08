package de.hwr.staffbase2.model.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hwr.staffbase2.model.ConnectionFactory;
import de.hwr.staffbase2.model.Job;
import de.hwr.staffbase2.model.JobDAO;
import de.hwr.staffbase2.model.JobFactory;

public class JobDAOImpl implements JobDAO {

	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public void insert(Job job) {
		try {
			String queryString = "INSERT INTO job(id, name, description, salary) VALUES(?,?,?,?);";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, job.getId());
			preparedStatement.setString(2, job.getName());
			preparedStatement.setString(3, job.getDescription());
			preparedStatement.setFloat(4, job.getSalary());
			preparedStatement.executeUpdate();
			System.out.println("Insert of job with ID = " + job.getId()
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
	public void update(Job job) {
		try {
			String queryString = "UPDATE job SET name=?, description=?, salary=? WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, job.getName());
			preparedStatement.setString(2, job.getDescription());
			preparedStatement.setFloat(3, job.getSalary());
			preparedStatement.setLong(4, job.getId());
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
	public void delete(Job job) {
		String queryString = "DELETE FROM job WHERE id=?;";
		try {
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, job.getId());
			preparedStatement.executeUpdate();
			System.out.println("Remove of Job with name: "
					+ job.getName() + " and id: " + job.getId()
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
	public List<Job> find() {
		List<Job> jobs = new ArrayList<Job>();
		try {
			String queryString = "SELECT * FROM job";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Job job = JobFactory.getInstance().getJob();
				job.setId(resultSet.getLong("id"));
				job.setName(resultSet.getString("name"));
				job.setDescription(resultSet.getString("description"));
				job.setSalary(resultSet.getFloat("salary"));
				jobs.add(job);
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
		return jobs;
	}

	@Override
	public Job find(long id) {
		try {
			String queryString = "SELECT * FROM job WHERE id=?;";
			connection = ConnectionFactory.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Job job= JobFactory.getInstance().getJob();
				job.setId(id);
				job.setName(resultSet.getString("name"));
				job.setDescription(resultSet.getString("description"));
				job.setSalary(resultSet.getFloat("salary"));
				return job;
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
