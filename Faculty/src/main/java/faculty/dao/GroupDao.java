package faculty.dao;

import faculty.model.Group;
import faculty.model.Subject;

import java.util.List;

//import homeWork.facultyHibernate.exceptions.EntityNotFoundException;

public interface GroupDao  {

	List<Group> getGroupsThatStudySubject(Subject subject);
}
