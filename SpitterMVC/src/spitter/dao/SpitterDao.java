package spitter.dao;

import java.util.List;

import spitter.dto.Spitter;

public interface SpitterDao {

	public Long save(Spitter spitter);

	public void update(Spitter spitter);

	public void delete(Spitter spitter);

	public Spitter getById(Long id);
	
	public Spitter getByFirstname(String firstName);

	public List<Spitter> getAll();

}
