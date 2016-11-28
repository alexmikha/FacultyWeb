package faculty.dao.implementation;

import faculty.dao.SubjectDao;
import faculty.model.Subject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mi on 13.10.2016.
 */

@Component
public class SubjectDaoImpl implements SubjectDao<Subject, Integer> {

    @PersistenceContext
    private EntityManager manager;

    public SubjectDaoImpl() {
    }

    @Override
    @Transactional
    public List<Subject> getAll() {
        TypedQuery<Subject> nameQuery = manager.createNamedQuery("Subject.getAll", Subject.class);
        return nameQuery.getResultList();
    }

    @Override
    @Transactional
    public Subject addEntity(Subject entity) {
        manager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public boolean deleteEntity(Subject entity) {
        manager.remove(manager.contains(entity) ? entity : manager.merge(entity));
        return true;
    }

    @Override
    @Transactional
    public Subject updateEntity(Subject entity) {
        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }
        return entity;
    }

    @Override
    @Transactional
    public Subject getEntityById(Integer id) {
        return manager.find(Subject.class, id);
    }


    @Override
    public List<Subject> getHumanitarSubjects() {
        List<Subject> gumanitarSubjects = manager.createQuery("SELECT s FROM Subject s WHERE s.name IN ('history', 'language', 'economy')").getResultList();
        if (gumanitarSubjects != null) {
            return gumanitarSubjects;
        } else {
            throw new EntityNotFoundException("Humanitarian subjects not found");
        }
    }
}

