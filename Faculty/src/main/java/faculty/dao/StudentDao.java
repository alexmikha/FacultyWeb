package faculty.dao;

import faculty.exception.NotFoundObjectException;
import faculty.model.Student;

import java.util.List;

public interface StudentDao<E, K> extends GeneralDao<E, K> {

    List getListOfStudentsInGroup(String group);

   Student findLoginStudent(String login) throws NotFoundObjectException;

    Student getStudentByName(String name) throws NotFoundObjectException;

}
