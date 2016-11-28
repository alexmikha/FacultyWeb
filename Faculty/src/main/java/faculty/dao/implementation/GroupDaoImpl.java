package faculty.dao.implementation;

import faculty.dao.GroupDao;
import faculty.model.Group;
import faculty.model.Subject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mi on 10.10.2016.
 */

@Component
public class GroupDaoImpl implements GroupDao<Group, Integer> {

    @PersistenceContext
    private EntityManager manager;

    public GroupDaoImpl() {
    }

    @Override
    @Transactional
    public List<Group> getAll() {
        TypedQuery<Group> namedQuery = manager.createNamedQuery("Group.getAll", Group.class);
        return namedQuery.getResultList();
    }

    @Override
    @Transactional
    public Group addEntity(Group entity) {
        manager.persist(entity);
        return entity;
    }


    @Override
    @Transactional
    public boolean deleteEntity(Group entity) {
        Group found = manager.find(Group.class, entity.getId());
        manager.remove(found);
        return true;
    }

    @Override
    @Transactional
    public Group updateEntity(Group entity) {
        if (getEntityById(entity.getId()) != null) {
            manager.merge(entity);
        }
        return entity;
    }


    @Override
    @Transactional
    public Group getEntityById(Integer id) {
        return manager.find(Group.class, id);
    }


    @Override
    @Transactional
    public List<Group> getGroupsThatStudySubject(Subject subject) {
        TypedQuery<Group> query = manager.createQuery("SELECT g FROM Group g join g.subjectList s WHERE s.name = :subjectName", Group.class);
        query.setParameter("subjectName", subject.getSubjectName());
        return query.getResultList();
    }
}
