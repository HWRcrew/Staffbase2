package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * Test fuer JobDAO
 * 
 * @author sebastiangrosse
 * 
 */
public class JobDAOTest {

	@Test
	public void testInsertAndFindById() {
		Job job = JobFactory.getInstance().getJob();
		job.setName("Entwickler");
		job.setSalary(4125);
		job.setDescription("Stelle eines Entwickler. Entwickler sind für die Programmierung und das logische Design der Software verantwortlich.");
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		jobDAO.insert(job);
		assertEquals("Entwickler", jobDAO.find(job.getId()).getName());
		assertEquals(
				"Stelle eines Entwickler. Entwickler sind für die Programmierung und das logische Design der Software verantwortlich.",
				jobDAO.find(job.getId()).getDescription());
		assertEquals(4125, jobDAO.find(job.getId()).getSalary(), 0);
	}

	@Test
	public void testUpdate() {
		Job job = JobFactory.getInstance().getJob();
		job.setName("Entwickler");
		job.setSalary(4125);
		job.setDescription("Stelle eines Entwickler. Entwickler sind für die Programmierung und das logische Design der Software verantwortlich.");
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		jobDAO.insert(job);

		// Job erhält neue Werte
		job.setName("Developer");
		job.setDescription("A Developer.");
		job.setSalary(4394);
		// Update
		jobDAO.update(job);
		assertEquals("Developer", jobDAO.find(job.getId()).getName());
		assertEquals("A Developer.", jobDAO.find(job.getId()).getDescription());
		assertEquals(4394, jobDAO.find(job.getId()).getSalary(), 0);
	}

	@Test
	public void testDelete() {
		Job job = JobFactory.getInstance().getJob();
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		// Insert
		jobDAO.insert(job);
		// Delete
		jobDAO.delete(job);
		// Test ob Id in DB
		assertNull(jobDAO.find(job.getId()));
	}

	@Test
	public void testInsertAndFindAll() {
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		Job job = JobFactory.getInstance().getJob();
		job.setName("Entwickler");
		job.setSalary(4125);
		Job job2 = JobFactory.getInstance().getJob();
		job2.setName("Verkäufer");
		job2.setSalary(1234);
		jobDAO.insert(job);
		jobDAO.insert(job2);
		List<Job> jobs = jobDAO.find();
		// Teste ob Job mit id in der Liste ist
		boolean test = false;
		boolean test2 = false;
		for (int i = 0; i < jobs.size(); i++) {
			if (jobs.get(i).getId() == job.getId()) {
				test = true;
			}
			if (jobs.get(i).getId() == job2.getId()) {
				test2 = true;
			}
		}
		assertTrue(test);
		assertTrue(test2);
	}
}
