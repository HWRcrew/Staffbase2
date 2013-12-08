package de.hwr.staffbase2.model;

import java.util.List;

/**
 * DAO für den Zugriff auf einen Account in der Persistenzschicht
 * 
 * @author sebastiangrosse
 * 
 */
public interface AccountDAO {

	public boolean insert(Account account);

	public boolean update(Account account);

	public void delete(Account account);

	public Account find(String username, String password);

	public Account find(String username);

	public Account find(long id);

	public List<Account> find();
}
