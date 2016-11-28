package faculty.dao.implementation;

import faculty.dao.TeacherDao;
import faculty.exception.NotFoundObjectException;
import faculty.model.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */

@Component
public class TeacherDaoImpl implements TeacherDao<Teacher, Integer> {

    @PersistenceContext
    private EntityManager manager;

    public TeacherDaoImpl() {

    }

    @Override
    @Transactional
    public List<Teacher> getAll() {
        TypedQuery<Teacher> namedQuery = manager.createNamedQuery("Teacher.getAll", Teacher.class);
        return namedQuery.getResultList();
    }

    @Override
    @Transactional
    public Teacher addEntity(Teacher teacher) {
        manager.persist(teacher);
        return teacher;
    }

    @Override
    @Transactional
    public boolean deleteEntity(Teacher teacher) {
        manager.remove(manager.contains(teacher));
        return true;
    }


    @Override
    @Transactional
    public Teacher updateEntity(Teacher teacher) {
        if (getEntityById(teacher.getId()) != null) {
            manager.merge(teacher);
        }
        return teacher;
    }

    @Override
    @Transactional
    public Teacher getEntityById(Integer id) {
        return manager.find(Teacher.class, id);
    }


    @Override
    @Transactional
    public List<Teacher> getMaxExperienceTeacher() {
        List<Teacher> teachers = manager.createQuery
                ("SELECT t FROM Teacher t WHERE t.experience = (SELECT MAX(tt.experience) FROM Teacher tt)").getResultList();
        if (teachers.size() != 0) {
            return teachers;
        } else {
            throw new EntityNotFoundException("Teacher have not max experience");
        }
    }


    @Override
    //   @Transactional
    public List<Teacher> getLessExperienceTeacher() {
        List<Teacher> teachers = manager.createQuery
                ("SELECT t FROM Teacher t WHERE t.experience = (SELECT MIN(tt.experience) FROM Teacher tt)").getResultList();
        if (teachers.size() != 0) {
            return teachers;
        } else {
            throw new EntityNotFoundException("Teacher have not less experience");
        }
    }

    @Override
    //  @Transactional
    public List<Teacher> getTeachersWithMoreYearsExperience(int experience) {
        List<Teacher> teachers = manager.createQuery("SELECT t FROM Teacher t WHERE t.experience > :experience").
                setParameter("experience", experience).getResultList();
        if (teachers != null) {
            return teachers;
        } else {
            throw new EntityNotFoundException("No teachers taught for more than " + experience + " years");
        }
    }

    @Override
    public Teacher findLoginTeacher(String login) throws NotFoundObjectException {
        Teacher teacher = null;
        if (login.equals(teacher.getTeacherName())) {
            return teacher;
        }
        if (teacher.getTeacherName() == null)
            try {
                throw new NotFoundObjectException("no teacher with login " + login);
            } catch (NotFoundObjectException e) {
                e.printStackTrace();
            }
        return null;
    }


    @Override
    public Teacher getTeacherBySubjectName(String subjectName) {
        return null;
    }
}