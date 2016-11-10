package faculty.soap.endpoint;

import faculty.dto.StudentDTO;
import faculty.exception.NoStudentFoundException;
import faculty.exception.RegisterException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Mi on 08.11.2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentEndpoint {

    @WebMethod
    StudentDTO loginStudent(String login) throws NoStudentFoundException;

    @WebMethod
    StudentDTO getStudentInfo(int id) throws NoStudentFoundException;

    @WebMethod
    StudentDTO createStudent(StudentDTO newStudent) throws RegisterException;

    @WebMethod
    StudentDTO GetAllStudent() throws NoStudentFoundException;
}
