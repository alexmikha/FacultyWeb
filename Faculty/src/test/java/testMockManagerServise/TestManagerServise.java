package testMockManagerServise;

import faculty.dao.implementation.GroupDaoImpl;
import faculty.dao.implementation.StudentDaoImpl;
import faculty.dao.implementation.SubjectDaoImpl;
import faculty.dao.implementation.TeacherDaoImpl;
import faculty.exception.NoStudentFoundException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.model.Subject;
import faculty.model.Teacher;
import faculty.service.ManagerService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Mi on 06.11.2016.
 */

//@RunWith(MockitoJUnitRunner.class)
public class TestManagerServise {

 //   @Mock
    private static ManagerService service;
 //   @Mock
    private static StudentDaoImpl studentDaoService;
 //   @Mock
    private static GroupDaoImpl groupDaoService;
 //   @Mock
    private static SubjectDaoImpl subjectDaoService;
 //   @Mock
    private static TeacherDaoImpl teacherDaoService;

    @BeforeClass
    public static void init() throws SQLException {

        studentDaoService = mock(StudentDaoImpl.class);
        groupDaoService = mock(GroupDaoImpl.class);
        subjectDaoService = mock(SubjectDaoImpl.class);
        teacherDaoService = mock(TeacherDaoImpl.class);

        Group group1 = new Group("gr1");
        Group group2 = new Group("gr2");
        Group group3 = new Group("gr3");

        Student student1 = new Student("name1", group1);
        Student student2 = new Student("name2", group2);
        Student student3 = new Student("name3", group3);

        Subject subject1 = new Subject("sub1", "sub1");
        Subject subject2 = new Subject("sub2", "sub2");
        Subject subject3 = new Subject("sub3", "sub3");

        Teacher teacher1 = new Teacher("teacher1", 5, subject1);
        Teacher teacher2 = new Teacher("teacher2", 10, subject2);
        Teacher teacher3 = new Teacher("teacher3", 15, subject3);

        when(studentDaoService.insertEntity(notNull(Student.class))).thenReturn(student3);
        when(studentDaoService.getAll()).thenReturn(Arrays.asList(student1, student2, student3));
        when(studentDaoService.updateEntity(notNull(Student.class))).thenReturn(student2);
        when(studentDaoService.getEntityById(anyInt())).thenReturn(student1);
        when(studentDaoService.getListOfStudentsInGroup(notNull(Group.class))).thenReturn(Arrays.
                asList(student1, student2, student3));

        when(teacherDaoService.insertEntity(notNull(Teacher.class))).thenReturn(teacher3);
        when(teacherDaoService.getAll()).thenReturn(Arrays.asList(teacher1, teacher2, teacher3));
        when(teacherDaoService.updateEntity(notNull(Teacher.class))).thenReturn(teacher2);
        when(teacherDaoService.getEntityById(anyInt())).thenReturn(teacher1);
        when(teacherDaoService.getMaxExperienceTeacher()).thenReturn(Arrays.
                asList(teacher1, teacher2, teacher3));

        when(subjectDaoService.insertEntity(notNull(Subject.class))).thenReturn(subject1);
        when(subjectDaoService.getAll()).thenReturn(Arrays.asList(subject1, subject2, subject3));
        when(subjectDaoService.updateEntity(notNull(Subject.class))).thenReturn(subject1);
        when(subjectDaoService.getEntityById(anyInt())).thenReturn(subject1);
        when(subjectDaoService.getHumanitarSubjects()).thenReturn(Arrays.asList(subject1, subject2, subject3));

        when(groupDaoService.insertEntity(notNull(Group.class))).thenReturn(group1);
        when(groupDaoService.getAll()).thenReturn(Arrays.asList(group1, group2, group3));
        when(groupDaoService.updateEntity(notNull(Group.class))).thenReturn(group2);
        when(groupDaoService.getEntityById(anyInt())).thenReturn(group3);
        // when(groupDaoService.getGroupsThatStudySubject().thenReturn(Arrays.asList(group1, group2, group3));

        service = new ManagerService(groupDaoService, studentDaoService, teacherDaoService, subjectDaoService);

    }

    @Test
    public void createStudent() throws SQLException {
        assertNotNull(service.createStudent(
                new Student("1", new Group("1"))));
    }

    @Test
    public void getAllStudents() throws SQLException, NoStudentFoundException {
        assertNotNull(service.getAllStudents());
    }

    @Test
    public void updateStudent() throws SQLException {
        assertNotNull(service.updateStudent(new Student("name1", new Group("gr1"))));
    }

    @Test
    public void getEntityById() throws SQLException {
        assertNotNull(service.findStudentById(1));
    }

    @Test
    public void getListOfStudentsInGroup() throws SQLException {
        Group group = new Group("gr1");
        assertNotNull(service.getListOfStudentsInGroup(group));
    }
}
