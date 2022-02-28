package ae.spring.orm.musicstore.dao;

import java.io.Serializable;
import java.util.List;

import ae.spring.orm.musicstore.dto.BasePojo;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 *
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public interface BaseDao<T extends BasePojo, PK extends Serializable>
{
    int countAll();

    boolean exists(PK id);

    T findUnique(final String queryString, final Object... values);

    T get(PK id);

    List<T> getAll();

    void remove(T object);

    void save(T object);
}
