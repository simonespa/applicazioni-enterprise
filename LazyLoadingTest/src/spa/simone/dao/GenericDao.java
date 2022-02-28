package spa.simone.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable> {

	public Long save(T dto);

	public void delete(T dto);

	public void update(T dto);

	public T findById(Long id, boolean proxy);

	public List<T> findAll();

}
