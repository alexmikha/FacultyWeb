package faculty.soap.endpoint;

import faculty.dto.StudentDTO;
import faculty.dto.StudentList;
import faculty.exception.NoStudentFoundException;
import faculty.exception.RegisterException;
import faculty.model.Student;
import faculty.service.ManagerService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mi on 07.11.2016.
 */
@WebService(endpointInterface = "faculty.soap.endpoint.StudentEndpoint")
public class StudentEndpointImpl implements StudentEndpoint {

    private ManagerService managerService;

    public StudentEndpointImpl() {
    }

    public StudentEndpointImpl(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public StudentDTO loginStudent(String login) throws NoStudentFoundException {
        Student student = managerService.loginStudent(login);
        return new StudentDTO(student.getId(), student.getStudentName(), student.getGroup());
    }

    @Override
    public StudentDTO getStudentInfo(int id) throws NoStudentFoundException{
        Student student = managerService.findStudentById(id);
        return new StudentDTO(student.getId(), student.getStudentName(), student.getGroup());
    }


    @Override
    public StudentDTO createStudent(StudentDTO newStudent) throws RegisterException{
        Student student = managerService.createStudent(new Student(newStudent.getName(), newStudent.getGroup()));
        return new StudentDTO(student.getId(), student.getStudentName(), student.getGroup());
    }

    @Override
    public StudentDTO GetAllStudent() throws NoStudentFoundException{
              List<Student> students = managerService.getAllStudents();
              return getStudentList(students);
     //   return null;
    }

    private StudentList getStudentList(List<Student> students) {
        StudentList studentList = new StudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            studentDTOs.add(new StudentDTO(student.getId(), student.getStudentName(), student.getGroup()));
        }
        studentList.setDtoList(studentDTOs);
        return studentList;
    }
}
