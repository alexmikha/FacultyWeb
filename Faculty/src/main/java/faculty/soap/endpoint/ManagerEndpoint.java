package faculty.soap.endpoint;

import faculty.dto.StudentDTO;
import faculty.exception.NotFoundIdException;
import faculty.exception.NotFoundObjectException;
import faculty.exception.RegisterException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Mi on 08.11.2016.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ManagerEndpoint {

    @WebMethod
    StudentDTO loginStudent(String login) throws NotFoundObjectException;

    @WebMethod
    StudentDTO getStudentInfo(int id) throws NotFoundObjectException, NotFoundIdException;

    @WebMethod
    StudentDTO createStudent(StudentDTO newStudent) throws RegisterException;

    @WebMethod
    StudentDTO GetAllStudent() throws NotFoundObjectException, NotFoundIdException;

    @WebMethod
    StudentDTO findStudentById(int id) throws NotFoundIdException, NotFoundObjectException;

//    @WebMethod
//    GroupDTO findGroupById(Object id) throws NoIdFoundException;
}
