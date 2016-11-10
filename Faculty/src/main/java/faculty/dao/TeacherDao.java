package faculty.dao;

import faculty.exception.NoTeacherFoundException;
import faculty.model.Teacher;


import java.util.List;

public interface TeacherDao  {

	List<Teacher> getMaxExperienceTeacher(); //throws EntityNotFoundException;

	List<Teacher> getLessExperienceTeacher(); //throws EntityNotFoundException;

	List<Teacher> getTeachersWithMoreYearsExperience(int experience); //throws EntityNotFoundException, InvalidNumberException;

	Teacher loginTeacher(String login, String pass) throws NoTeacherFoundException;
}
