package faculty.run_spring;

import faculty.exception.NoStudentFoundException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.service.ManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mi on 2.11.16.
 */
public class StartAppFaculty {


    public static void main(String[] args) throws SQLException, NoStudentFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/app-faculty-context.xml");
        ManagerService managerService = context.getBean(ManagerService.class);

        managerService.createStudent(new Student("Ketty", new Group("IT_2")));

        List<Student> studentList = managerService.getAllStudents();
        studentList.stream().forEach(System.out::println);

    }
}
