package faculty.dao.implementation;

import faculty.dao.GeneralDao;
import faculty.dao.SubjectDao;
import faculty.model.Subject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mi on 13.10.2016.
 */
@Repository
@Component
public class SubjectDaoImpl implements GeneralDao<Subject, Integer>, SubjectDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Subject> getAll()  {
       TypedQuery<Subject> nameQuery = manager.createNamedQuery("Subject.getAll", Subject.class);
        return nameQuery.getResultList();
    }

    @Override
    public Subject insertEntity(Subject entity) {
     manager.persist(entity);
        return entity;
    }

    @Override
    public boolean deleteEntity(Subject entity) {
     manager.remove(manager.contains(entity) ? entity:manager.merge(entity));
        return true;
    }

    @Override
    public Subject updateEntity(Subject entity){
        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }
        return entity;
    }

    @Override
    public Subject getEntityById(Integer id){
     return manager.find(Subject.class, id);
    }

    @Override
    public List<Subject> getHumanitarSubjects() {
        List<Subject> gumanitariumSubjects = manager.createQuery("SELECT s FROM Subject s WHERE s.name IN ('history', 'language', 'economy')").getResultList();
        if (gumanitariumSubjects != null) {
            return gumanitariumSubjects;
        } else {
            throw new EntityNotFoundException("Humanitarian subjects not found" );
        }
    }
}

