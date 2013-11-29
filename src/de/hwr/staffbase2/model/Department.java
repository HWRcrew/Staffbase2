package de.hwr.staffbase2.model;

/**
 * Abteilung eines Nutzers
 * 
 * @author sebastiangrosse
 *
 */
public interface Department {
	public long getId();

	public void setId(long id);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);
}
