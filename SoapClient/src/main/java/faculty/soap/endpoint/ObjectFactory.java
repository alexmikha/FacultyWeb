
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

    private final static QName _NotFoundIdException_QNAME = new QName("http://endpoint.soap.faculty/", "NotFoundIdException");
    private final static QName _Student_QNAME = new QName("http://endpoint.soap.faculty/", "student");
    private final static QName _RegisterException_QNAME = new QName("http://endpoint.soap.faculty/", "RegisterException");
    private final static QName _NotFoundObjectException_QNAME = new QName("http://endpoint.soap.faculty/", "NotFoundObjectException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: faculty.soap.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotFoundIdException }
     * 
     */
    public NotFoundIdException createNotFoundIdException() {
        return new NotFoundIdException();
    }

    /**
     * Create an instance of {@link StudentDTO }
     * 
     */
    public StudentDTO createStudentDTO() {
        return new StudentDTO();
    }

    /**
     * Create an instance of {@link NotFoundObjectException }
     * 
     */
    public NotFoundObjectException createNotFoundObjectException() {
        return new NotFoundObjectException();
    }

    /**
     * Create an instance of {@link RegisterException }
     * 
     */
    public RegisterException createRegisterException() {
        return new RegisterException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundIdException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.faculty/", name = "NotFoundIdException")
    public JAXBElement<NotFoundIdException> createNotFoundIdException(NotFoundIdException value) {
        return new JAXBElement<NotFoundIdException>(_NotFoundIdException_QNAME, NotFoundIdException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.faculty/", name = "RegisterException")
    public JAXBElement<RegisterException> createRegisterException(RegisterException value) {
        return new JAXBElement<RegisterException>(_RegisterException_QNAME, RegisterException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotFoundObjectException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.soap.faculty/", name = "NotFoundObjectException")
    public JAXBElement<NotFoundObjectException> createNotFoundObjectException(NotFoundObjectException value) {
        return new JAXBElement<NotFoundObjectException>(_NotFoundObjectException_QNAME, NotFoundObjectException.class, null, value);
    }

}
