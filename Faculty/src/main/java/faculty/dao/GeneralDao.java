package faculty.dao;

import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
public interface GeneralDao<E, K> {
    List<E> getAll();

    E insertEntity(E entity);

    boolean deleteEntity(E entity);

    E updateEntity(E entity);

    E getEntityById(K id);


}