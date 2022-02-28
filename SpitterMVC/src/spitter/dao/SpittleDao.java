package spitter.dao;

import java.util.List;

import spitter.dto.Spittle;

public interface SpittleDao {

	public Long save(Spittle spittle);

	public void update(Spittle spittle);

	public void delete(Spittle spittle);

	public Spittle getById(Long id);

	public List<Spittle> getFirst(Integer size);
	
	public List<Spittle> getAll();

}
