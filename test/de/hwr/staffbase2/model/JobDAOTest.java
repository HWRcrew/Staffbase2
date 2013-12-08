package de.hwr.staffbase2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class JobDAOTest {

	@Test
	public void testInsertAndFindById() {
		Job job = JobFactory.getInstance().getJob();
		job.setName("Entwickler");
		System.out.println(job.getName());
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

		// Job erhält neue Parameter
		job.setName("Developer");
		job.setDescription("A Developer.");
		job.setSalary(4394);
		// Update
		jobDAO.update(job);
		assertEquals("Developer", jobDAO.find(job.getId()).getName());
		assertEquals("A Developer.", jobDAO.find(job.getId()).getDescription());
		assertEquals(4125, jobDAO.find(job.getId()).getSalary(), 0);
	}

	@Test
	public void testDelete() {
		Job job = JobFactory.getInstance().getJob();
		job.setName("Entwickler");
		job.setSalary(4125);
		job.setDescription("Stelle eines Entwickler. Entwickler sind für die Programmierung und das logische Design der Software verantwortlich.");
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		jobDAO.insert(job);
		jobDAO.delete(job);
		assertNull(jobDAO.find(job.getId()));
	}

	@Test
	public void testInsertAndFindAll() {
		JobDAO jobDAO = JobDAOFactory.getInstance().getJobDAO();
		Job job = JobFactory.getInstance().getJob();
		job.setName("Entwickler");
		job.setSalary(4125);
		List<Job> jobs = jobDAO.find();
		// Teste ob Job in mit id in der Liste
		assertTrue(jobs.contains(job.getId()));
	}
}
