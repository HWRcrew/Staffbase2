package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.JobDAOImpl;

/**
 * Factory zur Erzeugung eines DAO fuer Jobs (bisher nur für Datenbanken)
 * 
 * @author sebastiangrosse
 * 
 */
public class JobDAOFactory {
	private static JobDAOFactory jobDAOFactory = null;

	public JobDAO getJobDAO() {
		JobDAO jobDAO = new JobDAOImpl();
		return jobDAO;
	}

	public static JobDAOFactory getInstance() {
		if (jobDAOFactory == null) {
			jobDAOFactory = new JobDAOFactory();
		}
		return jobDAOFactory;
	}
}
