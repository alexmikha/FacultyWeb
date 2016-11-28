package faculty.dao.implementation;

import faculty.dao.StudentDao;
import faculty.exception.NotFoundObjectException;
import faculty.model.Student;
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
public class StudentDaoImpl implements StudentDao<Student, Integer> {


    @PersistenceContext
    private EntityManager manager;

    public StudentDaoImpl() {
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        TypedQuery<Student> namedQuery = manager.createNamedQuery("Student.getAll", Student.class);
        return namedQuery.getResultList();
    }

    @Override
    @Transactional
    public Student addEntity(Student student) {
        manager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public boolean deleteEntity(Student student) {
        manager.remove(manager.contains(student));
        return true;
    }


    @Override
    @Transactional
    public Student updateEntity(Student student) {
        if (getEntityById(student.getId()) != null) {
            manager.merge(student);
        }
        return student;
    }


    @Override
    @Transactional
    public Student getEntityById(Integer id) {
        return manager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List getListOfStudentsInGroup(String group) {
        List students = manager.createQuery("SELECT s FROM Student s WHERE s.group LIKE :group").
                setParameter("group", group).getResultList();
        if (students != null) {
            return students;
        } else {
            throw new EntityNotFoundException("Students with group " + group + "not found");
        }
    }

    @Override
    @Transactional()
    public Student findLoginStudent(String login) throws NotFoundObjectException {
        TypedQuery<Student> query = manager.createQuery("SELECT s FROM Student s WHERE s.studentName =:name", Student.class)
                .setParameter("name", login);
        List<Student> students = query.getResultList();

        if (students == null || students.isEmpty()) {
            return null;
        }
        return students.get(0);
    }


    @Override
    public Student getStudentByName(String name) throws NotFoundObjectException {
        return null;
    }
}




