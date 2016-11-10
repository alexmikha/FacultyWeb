package faculty.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 08.11.2016.
 */
@XmlRootElement(name = "subject")
public class SubjectDTO {

    private int id;
    private String subjectName;
    private String description;

    public SubjectDTO() {
    }

    public SubjectDTO(int id, String subjectName, String description) {
        this.id = id;
        this.subjectName = subjectName;
        this.description = description;
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
