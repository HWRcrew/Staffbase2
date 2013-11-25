package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void testGetConnection() {
		Connection connection = null;
		try {
			connection = ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean connected = false;
		if (connection != null) {
			connected = true;
		}
		assertEquals(true, connected);
	}

}
