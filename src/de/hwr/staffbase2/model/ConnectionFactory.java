package de.hwr.staffbase2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Factory, zur Erzeugung einer Verbindung mit der Datenbank
 * 
 * @author sebastiangrosse
 * 
 */
public class ConnectionFactory {
	private static String DRIVERCLASSNAME = ConfigurationReader.getInstance()
			.read().getProperty("db.driverclassname");
	private static String CONNECTIONURL = ConfigurationReader.getInstance()
			.read().getProperty("db.connectionurl");
	private static String USER = ConfigurationReader.getInstance().read()
			.getProperty("db.user");
	private static String PASSWORD = ConfigurationReader.getInstance().read()
			.getProperty("db.password");

	private static ConnectionFactory connectionFactory = null;

	private ConnectionFactory() {
		try {
			Class.forName(DRIVERCLASSNAME);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(CONNECTIONURL,
				USER, PASSWORD);
		return connection;
	}
}
