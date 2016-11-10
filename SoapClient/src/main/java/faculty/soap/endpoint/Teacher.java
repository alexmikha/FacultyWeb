
package faculty.soap.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for teacher complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="teacher">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.soap.faculty/}idEntity">
 *       &lt;sequence>
 *         &lt;element name="experience" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="subject" type="{http://endpoint.soap.faculty/}subject" minOccurs="0"/>
 *         &lt;element name="teacherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "teacher", propOrder = {
    "experience",
    "subject",
    "teacherName"
})
public class Teacher
    extends IdEntity
{

    protected int experience;
    protected Subject subject;
    protected String teacherName;

    /**
     * Gets the value of the experience property.
     * 
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Sets the value of the experience property.
     * 
     */
    public void setExperience(int value) {
        this.experience = value;
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

    /**
     * Gets the value of the teacherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * Sets the value of the teacherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacherName(String value) {
        this.teacherName = value;
    }

}
