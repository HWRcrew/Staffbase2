package de.hwr.staffbase2.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Zum Lesen der Konfiguration - Die Konfiguration kann nicht zur Laufzeit veraendert
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
	 * Lesen der Properties aus configuration.properties - Staffbase_CONF als
	 * Umgebungsvariable erforderlich => Neustart des OS erforderlich
	 * 
	 * @return Properties
	 */
	public Properties read() {
		if (properties == null) {
			properties = new Properties();
			try {

				/*
				 * Laden der configuration aus Information in
				 * catalina.properties shared.loader=Pfad zum Verzeichnis mit
				 * der configuration.properties Datei
				 */
				InputStream inputStream = Thread.currentThread()
						.getContextClassLoader()
						.getResourceAsStream("configuration.properties");
				if (inputStream != null) {
					properties.load(inputStream);
				}
				/*
				 * Falls das nicht funktioniert hat wird versucht über eine zu
				 * konfigurierende Umgebungsvariable Zugriff zu nehmen. Dafür
				 * muss die Variable Staffbase_CONF den absoluten Pfad enthalten
				 */
				if (properties == null) {
					String configuration = System.getenv("Staffbase_CONF");
					if (configuration != null) {
						FileInputStream fileInputStream = new FileInputStream(
								configuration);
						properties.load(fileInputStream);
						System.out.println(configuration + " from environment");
					}
					if (properties == null) {
						/*
						 * Im letzten Fall wird die configuration.properties aus
						 * Staffbase2 geladen, dies dient zum Test des Readers
						 */
						properties.load(new FileInputStream(
								"configuration.properties"));
						System.out.println("from source");
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return properties;
	}

	/**
	 * Selbst definierter InputStream
	 * 
	 * @param inputStream
	 * @return Properties
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
