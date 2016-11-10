
package faculty.soap.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="group">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.soap.faculty/}idEntity">
 *       &lt;sequence>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="studentSet" type="{http://endpoint.soap.faculty/}student" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectSet" type="{http://endpoint.soap.faculty/}subject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "group", propOrder = {
    "groupName",
    "studentSet",
    "subjectSet"
})
public class Group
    extends IdEntity
{

    protected String groupName;
    @XmlElement(nillable = true)
    protected List<Student> studentSet;
    @XmlElement(nillable = true)
    protected List<Subject> subjectSet;

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the studentSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Student }
     * 
     * 
     */
    public List<Student> getStudentSet() {
        if (studentSet == null) {
            studentSet = new ArrayList<Student>();
        }
        return this.studentSet;
    }

    /**
     * Gets the value of the subjectSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subject }
     * 
     * 
     */
    public List<Subject> getSubjectSet() {
        if (subjectSet == null) {
            subjectSet = new ArrayList<Subject>();
        }
        return this.subjectSet;
    }

}
