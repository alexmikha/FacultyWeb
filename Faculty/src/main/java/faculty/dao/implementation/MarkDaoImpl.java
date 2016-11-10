package faculty.dao.implementation;

import faculty.dao.GeneralDao;
import faculty.dao.MarkDao;
import faculty.model.Mark;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Mi on 04.11.2016.
 */
@Repository
@Component
public class MarkDaoImpl implements GeneralDao<Mark,Integer>, MarkDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Mark> getAll() {
        TypedQuery<Mark> namedQuery = manager.createNamedQuery("Mark.getAll", Mark.class);
        return namedQuery.getResultList();
    }

    @Override
    public Mark insertEntity(Mark entity) {
        manager.persist(entity);
        return entity;
    }

    @Override
    public boolean deleteEntity(Mark entity)  {
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
        return true;
    }

    @Override
    public Mark updateEntity(Mark entity)  {
        if(getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }
        return entity;
    }

    @Override
    public Mark getEntityById(Integer id)  {
        return manager.find(Mark.class, id);
    }


}
