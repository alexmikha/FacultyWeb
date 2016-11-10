package faculty.service;

import faculty.dao.implementation.GroupDaoImpl;
import faculty.dao.implementation.StudentDaoImpl;
import faculty.dao.implementation.SubjectDaoImpl;
import faculty.dao.implementation.TeacherDaoImpl;
import faculty.exception.NoStudentFoundException;
import faculty.exception.NoTeacherFoundException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.model.Subject;
import faculty.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
@Service
@Component
@Transactional
public class ManagerService {

    @Autowired
    private GroupDaoImpl groupDaoService;

    @Autowired
    private StudentDaoImpl studentDaoService;

    @Autowired
    private TeacherDaoImpl teacherDaoService;

    @Autowired
    private SubjectDaoImpl subjectDaoService;


    public ManagerService(GroupDaoImpl groupDaoService, StudentDaoImpl studentDaoService, TeacherDaoImpl teacherDaoService, SubjectDaoImpl subjectDaoService) {
        this.groupDaoService = groupDaoService;
        this.studentDaoService = studentDaoService;
        this.teacherDaoService = teacherDaoService;
        this.subjectDaoService = subjectDaoService;
    }

    public ManagerService() {

    }

    public List<Student> getAllStudents() throws NoStudentFoundException {
        return studentDaoService.getAll();
    }

    public Student updateStudent(Student entity) {
        return studentDaoService.updateEntity(entity);
    }

    public Student createStudent(Student entity) {
        return studentDaoService.insertEntity(entity);
    }

    public boolean deleteStudent(Student entity) {
        return studentDaoService.deleteEntity(entity);
    }


    public Student findStudentById(Object id) {
        return studentDaoService.getEntityById((Integer) id);
    }

    public List<Student> getListOfStudentsInGroup(Group group) {
        return studentDaoService.getListOfStudentsInGroup(group);
    }

    public Student loginStudent(String login) throws NoStudentFoundException {
        return studentDaoService.loginStudent(login);
    }

    public List<Teacher> getAllTeacher() {
        return teacherDaoService.getAll();
    }

    public Teacher updateTeacher(Teacher entity) {
        return teacherDaoService.updateEntity(entity);
    }

    public Teacher createTeacher(Teacher entity) {
        return teacherDaoService.insertEntity(entity);
    }

    public boolean deleteTeacher(Teacher entity) {
        return teacherDaoService.deleteEntity(entity);
    }


    public Teacher findTeacherById(Object id) {
        return teacherDaoService.getEntityById((Integer) id);
    }

    public Teacher loginTeacher(String login, String pass) throws NoTeacherFoundException {
        return teacherDaoService.loginTeacher(login, pass);
    }

    public List<Group> getAllGroup() {
        return groupDaoService.getAll();
    }

    public Group updateGroup(Group entity) {
        return groupDaoService.updateEntity(entity);
    }

    public Group createGroup(Group entity) {
        return groupDaoService.insertEntity(entity);
    }

    public boolean deleteGroup(Group entity) {
        return groupDaoService.deleteEntity(entity);
    }


    public Group findGroupById(Object id) throws SQLException {
        return groupDaoService.getEntityById((Integer) id);
    }


    public List<Subject> getAllSubject() throws SQLException {
        return subjectDaoService.getAll();
    }


    public Subject updateSubject(Subject entity) throws SQLException {
        return subjectDaoService.updateEntity(entity);
    }


    public Subject createSubject(Subject entity) throws SQLException {
        return subjectDaoService.insertEntity(entity);
    }


    public boolean deleteSubject(Subject entity) throws SQLException {
        return subjectDaoService.deleteEntity(entity);
    }


    public Subject findSubjectById(Object id) throws SQLException {
        return subjectDaoService.getEntityById((Integer) id);
    }

    public GroupDaoImpl getGroupDaoService() {
        return groupDaoService;
    }

    public void setGroupDaoService(GroupDaoImpl groupDaoService) {
        this.groupDaoService = groupDaoService;
    }

    public StudentDaoImpl getStudentDaoService() {
        return studentDaoService;
    }

    public void setStudentDaoService(StudentDaoImpl studentDaoService) {
        this.studentDaoService = studentDaoService;
    }

    public TeacherDaoImpl getTeacherDaoService() {
        return teacherDaoService;
    }

    public void setTeacherDaoService(TeacherDaoImpl teacherDaoService) {
        this.teacherDaoService = teacherDaoService;
    }

    public SubjectDaoImpl getSubjectDaoService() {
        return subjectDaoService;
    }

    public void setSubjectDaoService(SubjectDaoImpl subjectDaoService) {
        this.subjectDaoService = subjectDaoService;
    }


}
