package de.hwr.staffbase2.model;

import de.hwr.staffbase2.model.implementation.JobImpl;

public class JobFactory {
private static JobFactory jobFactory = null;
	
	public Job getJob() {
		return new JobImpl();
	}
	
	public static JobFactory getInstance(){
		if (jobFactory == null){
			jobFactory = new JobFactory();
		}
		return jobFactory;
	}
}
