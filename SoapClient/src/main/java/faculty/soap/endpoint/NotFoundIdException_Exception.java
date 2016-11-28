
package faculty.soap.endpoint;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NotFoundIdException", targetNamespace = "http://endpoint.soap.faculty/")
public class NotFoundIdException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NotFoundIdException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NotFoundIdException_Exception(String message, NotFoundIdException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NotFoundIdException_Exception(String message, NotFoundIdException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: faculty.soap.endpoint.NotFoundIdException
     */
    public NotFoundIdException getFaultInfo() {
        return faultInfo;
    }

}
