package faculty.dao;

import faculty.exception.NotFoundObjectException;
import faculty.model.Teacher;

import java.util.List;

public interface TeacherDao<E, K> extends GeneralDao<E, K> {

	List<Teacher> getMaxExperienceTeacher();

	List<Teacher> getLessExperienceTeacher();

	List<Teacher> getTeachersWithMoreYearsExperience(int experience);

	Teacher findLoginTeacher(String login) throws NotFoundObjectException;

	Teacher getTeacherBySubjectName(String subjectName);
}
