package faculty.dto;

import faculty.model.Subject;

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

    public SubjectDTO(Subject subject) {
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.description = subject.getDescription();
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
