package faculty.dao;

import faculty.model.Group;
import faculty.model.Subject;

import java.util.List;



public interface GroupDao<E, K> extends GeneralDao<E, K>{

	List<Group> getGroupsThatStudySubject(Subject subject);
}
