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
	// TODO Property-File for Connection
	private static String DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
	private static String CONNECTIONURL = "jdbc:mysql://localhost:8889/database";
	private static String USER = "root";
	private static String PASSWORD = "root";

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
