package esercitazione;

import java.util.List;

public interface UserDAO {

	public void save(User user);
	
	public void delete(User user);
	
	public void findById(Long id);
	
	/*
	 * Utilizziamo le Query by example di Spring
	 */
	public User findByExample(User user);
	
	public List<User> findByName(String name);
	
	public List<User> findAll();
}
