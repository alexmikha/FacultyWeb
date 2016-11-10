
package faculty.soap.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://endpoint.soap.faculty/}idEntity">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupSet" type="{http://endpoint.soap.faculty/}group" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="markList" type="{http://endpoint.soap.faculty/}mark" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="subjectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="teacher" type="{http://endpoint.soap.faculty/}teacher" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subject", propOrder = {
    "description",
    "groupSet",
    "markList",
    "subjectName",
    "teacher"
})
public class Subject
    extends IdEntity
{

    protected String description;
    @XmlElement(nillable = true)
    protected List<Group> groupSet;
    @XmlElement(nillable = true)
    protected List<Mark> markList;
    protected String subjectName;
    protected Teacher teacher;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the groupSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Group }
     * 
     * 
     */
    public List<Group> getGroupSet() {
        if (groupSet == null) {
            groupSet = new ArrayList<Group>();
        }
        return this.groupSet;
    }

    /**
     * Gets the value of the markList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the markList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarkList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mark }
     * 
     * 
     */
    public List<Mark> getMarkList() {
        if (markList == null) {
            markList = new ArrayList<Mark>();
        }
        return this.markList;
    }

    /**
     * Gets the value of the subjectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the value of the subjectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectName(String value) {
        this.subjectName = value;
    }

    /**
     * Gets the value of the teacher property.
     * 
     * @return
     *     possible object is
     *     {@link Teacher }
     *     
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Sets the value of the teacher property.
     * 
     * @param value
     *     allowed object is
     *     {@link Teacher }
     *     
     */
    public void setTeacher(Teacher value) {
        this.teacher = value;
    }

}
