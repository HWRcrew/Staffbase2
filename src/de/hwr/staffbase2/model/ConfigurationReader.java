package de.hwr.staffbase2.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Zum Lesen der Konfiguration Konfiguration kann nicht zur Laufzeit veraendert
 * werden
 * 
 * @author sebastiangrosse
 * 
 */
public class ConfigurationReader {
	private static ConfigurationReader configurationReader = null;
	private Properties properties = null;

	public static ConfigurationReader getInstance() {
		if (configurationReader == null) {
			configurationReader = new ConfigurationReader();
		}
		return configurationReader;
	}

	/**
	 * Fest definiertes File
	 * 
	 * @return
	 */
	public Properties read() {
		if (properties == null) {
			try {
				properties = new Properties();
				properties
						.load(new FileInputStream("configuration.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}

	/**
	 * Selbst definierter InputStream
	 * 
	 * @param file
	 * @return
	 */
	public Properties read(InputStream inputStream) {
		if (properties == null) {
			try {
				properties = new Properties();
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
