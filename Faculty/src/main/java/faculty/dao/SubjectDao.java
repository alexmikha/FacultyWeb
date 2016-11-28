package faculty.dao;

import faculty.model.Subject;

import java.util.List;



public interface SubjectDao<E, K> extends GeneralDao<E, K>{

	List<Subject> getHumanitarSubjects();

}
