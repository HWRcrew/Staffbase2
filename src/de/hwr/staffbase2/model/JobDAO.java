package de.hwr.staffbase2.model;

import java.util.List;

public interface JobDAO {

	public void insert(Job job);
	
	public void update(Job job);
	
	public void delete(Job job);
	
	public List<Job> find();
	
	public Job find(long id);
}
