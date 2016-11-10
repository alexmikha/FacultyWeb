package faculty.dao.implementation;

import faculty.dao.GeneralDao;
import faculty.dao.TeacherDao;
import faculty.exception.NoTeacherFoundException;
import faculty.model.Teacher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by mi on 08.10.2016.
 */
@Repository
@Component
public class TeacherDaoImpl implements GeneralDao<Teacher, Integer>, TeacherDao {

    @PersistenceContext
    private EntityManager manager;


    public TeacherDaoImpl() {

    }

    @Override
    public List<Teacher> getAll(){
        TypedQuery<Teacher> namedQuery = manager.createNamedQuery("Teacher.getAll", Teacher.class);
        return namedQuery.getResultList();
    }

    @Override
    public Teacher insertEntity(Teacher teacher){
        manager.persist(teacher);
        return teacher;
    }

    @Override
    public boolean deleteEntity(Teacher teacher){
        manager.remove(manager.contains(teacher));
        return true;
    }


    @Override
    public Teacher updateEntity(Teacher teacher){
        if(getEntityById(teacher.getId()) != null) {
            manager.merge(teacher);
        }
        return teacher;
    }

    @Override
    public Teacher getEntityById(Integer id){

        return manager.find(Teacher.class, id);
    }

    @Override
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
    public List<Teacher> getTeachersWithMoreYearsExperience(int experience) {
        List<Teacher> teachers = manager.createQuery("SELECT t FROM Teacher t WHERE t.experience > :experience").
                setParameter("experience", experience).getResultList();
        if (teachers != null) {
            return teachers;
        } else {
            throw new EntityNotFoundException("No teachers taught for more than " + experience  + " years");
        }
    }

    @Override
    public Teacher loginTeacher(String login, String pass) throws NoTeacherFoundException{

        Teacher teacher = null;
        if (login.equals(teacher.getTeacherName()) && pass.equals("root")){
            return teacher;
        }
        if (teacher.getTeacherName() == null)
            throw new NoTeacherFoundException("no teacher with login " + login);
        return null;
    }
}