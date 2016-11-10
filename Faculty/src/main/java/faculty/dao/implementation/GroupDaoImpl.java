package faculty.dao.implementation;

import faculty.dao.GeneralDao;
import faculty.dao.GroupDao;
import faculty.model.Group;
import faculty.model.Subject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mi on 10.10.2016.
 */
@Repository
@Component
public class GroupDaoImpl implements GeneralDao<Group, Integer>, GroupDao  {
  //  private EntityManagerFactory factory;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Group> getAll() {
        TypedQuery<Group> namedQuery = manager.createNamedQuery("Group.getAll", Group.class);
        return namedQuery.getResultList();
    }

    @Override
    public Group insertEntity(Group entity) {
      manager.persist(entity);
        return entity;
    }

    @Override
    public boolean deleteEntity(Group entity)  {
     Group found = manager.find(Group.class, entity.getId());
        manager.remove(found);
        return true;
    }

    @Override
    public Group updateEntity(Group entity)  {
            if (getEntityById(entity.getId()) != null) {
                manager.merge(entity);
            }
        return entity;
    }


    @Override
    public Group getEntityById(Integer id)  {
       return manager.find(Group.class, id);
    }

    @Override
    public List<Group> getGroupsThatStudySubject(Subject subject) {
        TypedQuery<Group> query = manager.createQuery("SELECT n FROM Group n join n.subjectList s WHERE s.name = :subjectName", Group.class);
        query.setParameter("subjectName", subject.getSubjectName());
        return query.getResultList();
    }
}
