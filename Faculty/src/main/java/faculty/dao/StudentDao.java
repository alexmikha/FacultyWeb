package faculty.dao;

import faculty.exception.NoStudentFoundException;
import faculty.model.Group;
import faculty.model.Student;

import java.util.List;

public interface StudentDao  {

	List<Student> getListOfStudentsInGroup(Group group); //throws EntityNotFoundException;

	Student loginStudent(String login) throws NoStudentFoundException;
}
