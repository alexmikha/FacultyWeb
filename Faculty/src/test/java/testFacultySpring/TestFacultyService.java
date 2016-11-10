package testFacultySpring;

import faculty.exception.NoStudentFoundException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.service.ManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mi on 05.11.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-faculty-context.xml"})
public class TestFacultyService {

    @Autowired
    private ManagerService service;

    @Test
    public void createStudent() throws SQLException, NoStudentFoundException {
        Student student = service.createStudent(new Student("Aron3", new Group("IT_2")));
        List<Student> studentList = service.getAllStudents();

        boolean result = false;
        for (Student student1 : studentList) {
            if (student1.getStudentName().contains(student.getStudentName())) {
                System.out.println(result);
                result = true;
            }
        }

        Assert.assertTrue(result);
    }


    @Test
    public void createGroup() throws SQLException {
        Group group = service.createGroup(new Group("IT_3"));
        List<Group> groupList = service.getAllGroup();
        boolean result = false;
        for (Group group1 : groupList) {
            if (group1.getGroupName().contains(group.getGroupName())) {
                System.out.println(result);
                result = true;
            }
        }

        Assert.assertTrue(result);
    }
}