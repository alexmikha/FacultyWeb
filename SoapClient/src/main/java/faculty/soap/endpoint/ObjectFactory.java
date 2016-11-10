
package faculty.soap.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the faculty.soap.endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Student_QNAME = new QName("http://endpoint.soap.faculty/", "student");
    private final static QName _NoStudentFoundException_QNAME = new QName("http://endpoint.soap.faculty/", "NoStudentFoundException");
    private final static QName _RegisterException_QNAME = new QName("http://endpoint.soap.faculty/", "RegisterException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: faculty.soap.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentDTO }
     * 
     */
    public StudentDTO createStudentDTO() {
        return new StudentDTO();
    }

    /**
     * Create an instance of {@link RegisterException }
     * 
     */
    public RegisterException createRegisterException() {
        return new RegisterException();
    }

    /**
     * Create an instance of {@link NoStudentFoundException }
     * 
     */
    public NoStudentFoundException createNoStudentFoundException() {
        return new NoStudentFoundException();
    }

    /**
     * Create an instance of {@link IdEntity }
     * 
     */
    public IdEntity createIdEntity() {
        return new IdEntity();
    }

    /**
     * Create an instance of {@link Teacher }
     * 
     */
    public Teacher createTeacher() {
        return new Teacher();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Subject }
     * 
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Mark }
     * 
     */
    public Mark createMark() {
        return new Mark();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.faculty/", name = "student")
    public JAXBElement<StudentDTO> createStudent(StudentDTO value) {
        return new JAXBElement<StudentDTO>(_Student_QNAME, StudentDTO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoStudentFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.faculty/", name = "NoStudentFoundException")
    public JAXBElement<NoStudentFoundException> createNoStudentFoundException(NoStudentFoundException value) {
        return new JAXBElement<NoStudentFoundException>(_NoStudentFoundException_QNAME, NoStudentFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.faculty/", name = "RegisterException")
    public JAXBElement<RegisterException> createRegisterException(RegisterException value) {
        return new JAXBElement<RegisterException>(_RegisterException_QNAME, RegisterException.class, null, value);
    }

}
