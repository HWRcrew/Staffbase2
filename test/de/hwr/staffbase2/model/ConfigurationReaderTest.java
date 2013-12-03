package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;

public class ConfigurationReaderTest {

	@Test
	public void testRead() {
		 Properties properties = ConfigurationReader.getInstance().read(
		 getClass().getResourceAsStream("test.properties"));
		assertEquals("com.mysql.jdbc.Driver",
				properties.getProperty("db.driverclassname"));
		assertEquals("jdbc:mysql://localhost:8889/database",
				properties.getProperty("db.connectionurl"));
		assertEquals("root", properties.getProperty("db.user"));
		assertEquals("root", properties.getProperty("db.password"));
	}

}
