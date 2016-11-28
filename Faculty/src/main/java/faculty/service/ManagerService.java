package faculty.service;

import faculty.exception.NoCreateObjectException;
import faculty.exception.NotFoundIdException;
import faculty.exception.NotFoundObjectException;
import faculty.exception.RegisterException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.model.Subject;
import faculty.model.Teacher;

import java.util.List;

/**
 * Created by Mi on 11.11.2016.
 */
public interface ManagerService {

    //Student
    Student login(String login) throws   NotFoundObjectException;
    Student getStudentInfo(int id) throws   NotFoundObjectException, NotFoundIdException;
    Student createStudent(Student newStudent) throws  RegisterException;
    Student updateStudent(Student student) throws  NotFoundIdException;
    List<Student> getAllStudents() throws  NotFoundIdException;

    //Group
    List<Group> getAllGroups() throws Exception;
    Group addGroup(Group group) throws NoCreateObjectException;
    Group updateGroup(Group group) throws  NotFoundIdException ;
    Group findGroupById(int id) throws  NotFoundIdException;
    List<Group> getGroupsThatStudySubject(Subject subject);


    //Teacher
    List<Teacher> getAllTeachers() throws  NotFoundIdException;
    Teacher getTeacherBySubject(String subjectName) throws  NotFoundIdException;
    Teacher addTeacher(Teacher teacher)  throws  RegisterException;
    List<Teacher> getTeacherWithMaxExp() throws  NotFoundIdException;
    Teacher updateTeacher(Teacher teacher);
    Teacher findTeacherById(int id) throws  NotFoundIdException;

    //Subject
    List<Subject> getAllSubjects() throws  NotFoundObjectException;
    Subject addSubject(Subject subject) throws  RegisterException;
    Subject updateSubject(Subject subject) throws  NotFoundIdException;
    Subject findSubjectById(int id) throws  NotFoundIdException;
    List<Subject> getHumanitarSubjects(String descr) throws  NotFoundObjectException;
}
