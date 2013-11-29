package de.hwr.staffbase2.model;

import java.util.List;

/**
 * DAO zum Zugriff auf Job-Daten in der Persistenzschicht
 * 
 * @author sebastiangrosse
 * 
 */
public interface JobDAO {

	public void insert(Job job);

	public void update(Job job);

	public void delete(Job job);

	public List<Job> find();

	public Job find(long id);
}
