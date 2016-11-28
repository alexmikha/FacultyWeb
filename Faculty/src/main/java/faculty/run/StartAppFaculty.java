package faculty.run;


import faculty.exception.NotFoundIdException;
import faculty.exception.NotFoundObjectException;
import faculty.model.Student;
import faculty.service.ManagerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mi on 2.11.16.
 */
public class StartAppFaculty {


    public static void main(String[] args) throws SQLException, NotFoundObjectException, NotFoundIdException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/app-faculty-context.xml");
        ManagerServiceImpl managerService = context.getBean(ManagerServiceImpl.class);

        List<Student> studentList = managerService.getAllStudents();
        studentList.stream().forEach(System.out::println);

    }
}
