package faculty.service;

import faculty.dao.GroupDao;
import faculty.dao.StudentDao;
import faculty.dao.SubjectDao;
import faculty.dao.TeacherDao;
import faculty.exception.NotFoundIdException;
import faculty.exception.NotFoundObjectException;
import faculty.exception.RegisterException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.model.Subject;
import faculty.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
@Component
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private GroupDao<Group, Integer> groupDao;

    @Autowired
    private StudentDao<Student, Integer> studentDao;

    @Autowired
    private TeacherDao<Teacher, Integer> teacherDao;

    @Autowired
    private SubjectDao<Subject, Integer> subjectDao;


//    public ManagerServiceImpl(GroupDao<Group, Integer> groupDao, StudentDao<Student, Integer> studentDao,
//                              TeacherDao<Teacher, Integer> teacherDao, SubjectDao<Subject, Integer> subjectDao) {
//        this.groupDao = groupDao;
//        this.studentDao = studentDao;
//        this.teacherDao = teacherDao;
//        this.subjectDao = subjectDao;
//    }

    public ManagerServiceImpl() {
    }

    public GroupDao<Group, Integer> getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDao<Group, Integer> groupDao) {
        this.groupDao = groupDao;
    }

    public StudentDao<Student, Integer> getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao<Student, Integer> studentDao) {
        this.studentDao = studentDao;
    }

    public TeacherDao<Teacher, Integer> getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDao<Teacher, Integer> teacherDao) {
        this.teacherDao = teacherDao;
    }

    public SubjectDao<Subject, Integer> getSubjectDao() {
        return subjectDao;
    }

    public void setSubjectDao(SubjectDao<Subject, Integer> subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    @Transactional
    public Student login(String login) throws NotFoundObjectException {
        Student student = studentDao.findLoginStudent(login);

        if (student == null) {
            throw new NotFoundObjectException("ERROR no student with login " + login);
        }
        return student;


    }

    @Override
    @Transactional
    public Student getStudentInfo(int id) throws NotFoundObjectException, NotFoundIdException {
        Student student = studentDao.getEntityById(id);
        if (student == null) {
            throw new NotFoundIdException("ERROR not student this id");
        }
        return student;
    }

    @Override
    @Transactional
    public Student createStudent(Student newStudent) throws RegisterException {
        return studentDao.insertEntity(newStudent);
    }


    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDao.updateEntity(student);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() throws NotFoundIdException {
        List<Student> studentList = studentDao.getAll();
        if (studentList.isEmpty()) {
            throw new NotFoundIdException("ERROR: studentList isEmpty");
        }
        return studentList;
    }

    @Override
    @Transactional
    public List<Group> getAllGroups() throws Exception {
        List<Group> groupList = groupDao.getAll();
        if (groupList.isEmpty()) {
            throw new NotFoundObjectException("ERROR list of group isEmpty");
        }
        return groupList;
    }

    @Override
    @Transactional
    public Group addGroup(Group group) {
        return groupDao.insertEntity(group);
    }

    @Override
    @Transactional
    public Group updateGroup(Group group) {
        return groupDao.updateEntity(group);
    }


    @Override
    @Transactional
    public Group findGroupById(int id) throws NotFoundIdException {
        Group group = groupDao.getEntityById(id);
        if (group == null) {
            throw new NotFoundIdException("ERROR not group this id");
        }
        return group;
    }

    @Override
    public List<Group> getGroupsThatStudySubject(Subject subject) {
        return getGroupDao().getGroupsThatStudySubject(subject);
    }

    @Override
    public List<Teacher> getAllTeachers() throws NotFoundIdException {
        List<Teacher> teacherList = teacherDao.getAll();
        if (teacherList.isEmpty()) {
            throw new NotFoundIdException(("ERROR: studentList isEmpty"));
        }
        return teacherList;
    }

    @Override
    @Transactional
    public Teacher getTeacherBySubject(String subjectName) throws NotFoundIdException {
        Teacher teacher = teacherDao.getTeacherBySubjectName(subjectName);
        return teacher;
    }

    @Override
    @Transactional
    public Teacher addTeacher(Teacher teacher) {
        return teacherDao.insertEntity(teacher);
    }

    @Override
    public List<Teacher> getTeacherWithMaxExp() {
        return teacherDao.getMaxExperienceTeacher();

    }

    @Override
    @Transactional
    public Teacher updateTeacher(Teacher teacher) {
        return teacherDao.updateEntity(teacher);
    }

    @Override
    @Transactional
    public Teacher findTeacherById(int id) throws NotFoundIdException {
        Teacher teacher = teacherDao.getEntityById(id);
        if (teacher == null)
            throw new NotFoundIdException("ERROR not teacher this id");
        return teacher;
    }

    @Override
    public List<Subject> getAllSubjects() throws NotFoundObjectException {
        List<Subject> subjectList = subjectDao.getAll();
        if (subjectList.isEmpty())
            throw new NotFoundObjectException("ERROR: subjectList isEmpty");
        return subjectList;
    }

    @Override
    @Transactional
    public Subject addSubject(Subject subject) {
        return subjectDao.insertEntity(subject);
    }

    @Override
    @Transactional
    public Subject updateSubject(Subject subject) {
        return subjectDao.updateEntity(subject);
    }

    @Override
    @Transactional
    public Subject findSubjectById(int id) throws NotFoundIdException {
        Subject subject = subjectDao.getEntityById(id);
        if (subject == null)
            throw new NotFoundIdException("ERROR not subject this id");
        return subject;
    }

    @Override
    public List<Subject> getHumanitarSubjects(String descr) throws NotFoundObjectException {
        String humanSubject = "human";
        List<Subject> subjectList = subjectDao.getHumanitarSubjects();
        if (subjectList.isEmpty() || !subjectList.listIterator().next().getDescription().equals(humanSubject))
            throw new NotFoundObjectException("Sorry, not humanitarian subjects in subjectList");
        return subjectList;
    }
}
