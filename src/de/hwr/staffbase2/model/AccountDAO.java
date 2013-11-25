package de.hwr.staffbase2.model;

import java.util.List;

public interface AccountDAO {

	public void insert(Account account);

	public void update(Account account);

	public void delete(Account account);

	public Account find(String username, String password);

	public Account find(String username);

	public Account find(long id);

	public List<Account> find();
}
