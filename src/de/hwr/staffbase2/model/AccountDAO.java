package de.hwr.staffbase2.model;

import java.util.List;

/**
 * DAO für den Zugriff auf einen Account in der Persistenzschicht
 * 
 * @author sebastiangrosse
 * 
 */
public interface AccountDAO {

	/**
	 * Insert eines Account in die Datenbank - prueft ob bereits der Username
	 * vergeben ist.
	 * 
	 * @param account
	 * @return true bei Erfolg
	 */
	public boolean insert(Account account);

	/**
	 * Update eines account in der DB - prueft nicht den Username
	 * 
	 * @param account
	 * @return true bei Erfolg
	 */
	public boolean update(Account account);

	/**
	 * Loeschen des Account aus der DB anhand seiner id
	 */
	public void delete(Account account);

	/**
	 * Finde Account anhand von Username & Passwort
	 * 
	 * @param username
	 * @param password
	 * @return Account
	 */
	public Account find(String username, String password);

	/**
	 * Finde Account anhand von Username
	 * 
	 * @param username
	 * @return Account
	 */
	public Account find(String username);

	/**
	 * Finde Account anhand von Id
	 * 
	 * @param id
	 * @return Account
	 */
	public Account find(long id);

	/**
	 * Finde alle Accounts in der Datenbank
	 * 
	 * @return List of Accounts
	 */
	public List<Account> find();
}
