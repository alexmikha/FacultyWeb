package faculty.dao;

import faculty.model.Subject;

import java.util.List;



public interface SubjectDao {

	List<Subject> getHumanitarSubjects(); // throws EntityNotFoundException;

}
