package faculty.dao.implementation;

import faculty.dao.GeneralDao;
import faculty.dao.StudentDao;
import faculty.exception.NoStudentFoundException;
import faculty.model.Group;
import faculty.model.Student;
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
public class StudentDaoImpl implements GeneralDao<Student, Integer>, StudentDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> namedQuery = manager.createNamedQuery("Student.getAll", Student.class);
        return namedQuery.getResultList();
    }

    @Override
    public Student insertEntity(Student student) {
        manager.persist(student);
        return student;
    }

    @Override
    public boolean deleteEntity(Student student)  {
        manager.remove(manager.contains(student));
        return true;
    }


    @Override
    public Student updateEntity(Student student){
        if (getEntityById(student.getId()) != null) {
            manager.merge(student);
        }
        return student;
    }


    @Override
    public Student getEntityById(Integer id)  {
        return manager.find(Student.class, id);
    }

    @Override
    public List<Student> getListOfStudentsInGroup(Group group) {
        List<Student> students = manager.createQuery("SELECT s FROM Student s WHERE s.group LIKE :group").
                setParameter("group", group).getResultList();
        if (students != null) {
            return students;
        } else {
            throw new EntityNotFoundException("Students with group " + group + "not found");
        }
    }

    @Override
    public Student loginStudent(String login) throws NoStudentFoundException {
        TypedQuery<Student> query = manager.createQuery("SELECT s FROM Student s WHERE s.name =:name", Student.class)
                .setParameter("name", login);
        List<Student> students = query.getResultList();

        if(students == null || students.isEmpty()){
            return null;
        }

        return students.get(0);


    }
}
