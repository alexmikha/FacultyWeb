
package faculty.soap.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mark complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mark">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.soap.faculty/}idEntity">
 *       &lt;sequence>
 *         &lt;element name="mark" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="student" type="{http://endpoint.soap.faculty/}student" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://endpoint.soap.faculty/}subject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mark", propOrder = {
    "mark",
    "student",
    "subject"
})
public class Mark
    extends IdEntity
{

    protected int mark;
    protected Student student;
    protected Subject subject;

    /**
     * Gets the value of the mark property.
     * 
     */
    public int getMark() {
        return mark;
    }

    /**
     * Sets the value of the mark property.
     * 
     */
    public void setMark(int value) {
        this.mark = value;
    }

    /**
     * Gets the value of the student property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the value of the student property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setStudent(Student value) {
        this.student = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link Subject }
     *     
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subject }
     *     
     */
    public void setSubject(Subject value) {
        this.subject = value;
    }

}
