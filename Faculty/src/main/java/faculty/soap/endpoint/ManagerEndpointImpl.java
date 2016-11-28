package faculty.soap.endpoint;

import faculty.dto.StudentDTO;
import faculty.dto.StudentList;
import faculty.exception.NotFoundIdException;
import faculty.exception.NotFoundObjectException;
import faculty.exception.RegisterException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.service.ManagerService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mi on 07.11.2016.
 */
@WebService(endpointInterface = "faculty.soap.endpoint.ManagerEndpoint")
public class ManagerEndpointImpl implements ManagerEndpoint {

  private ManagerService managerService;

    public ManagerEndpointImpl() {
    }

    public ManagerEndpointImpl(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public StudentDTO loginStudent(String login) throws NotFoundObjectException {
        Student student = managerService.login(login);
          return new StudentDTO(student.getId(), student.getStudentName(), null);
      //  return new StudentDTO(student);
    }

    @Override
    public StudentDTO getStudentInfo(int id) throws NotFoundObjectException, NotFoundIdException {
        Student student = managerService.getStudentInfo(id);
          return new StudentDTO(student.getId(), student.getStudentName(), student.getGroup().getGroupName());
       // return new StudentDTO(student);
    }


    @Override
    public StudentDTO createStudent(StudentDTO newStudent) throws RegisterException {
        Student student = managerService.createStudent(new Student(newStudent.getName(), new Group(newStudent.getGroupName())));
         return new StudentDTO(student.getId(), student.getStudentName(), student.getGroup().getGroupName());
      //  return new StudentDTO(student);
    }

    @Override
    public StudentDTO GetAllStudent() throws NotFoundObjectException, NotFoundIdException {
        List<Student> studentList = managerService.getAllStudents();
        return getStudentList(studentList);
    }

    @Override
    public StudentDTO findStudentById(int id) throws NotFoundIdException, NotFoundObjectException {
        Student student = managerService.getStudentInfo(id);
        StudentDTO studentDTO = new StudentDTO(student);
        return studentDTO;

    }

    private StudentList getStudentList(List<Student> students) {
        StudentList studentList = new StudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student student : students) {
            //        studentDTOs.add(new StudentDTO(student.getId(), student.getStudentName(), student.getGroup()));
            studentDTOs.add(new StudentDTO(student));
        }
        studentList.setDtoList(studentDTOs);
        return studentList;
    }
}
