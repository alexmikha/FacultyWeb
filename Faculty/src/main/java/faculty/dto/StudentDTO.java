package faculty.dto;

import faculty.model.Student;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 7.11.16.
 */
@XmlRootElement(name = "student")
public class StudentDTO {


    private int id;
    private String name;
    private String groupName;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getStudentName();
        this.groupName = student.getGroup().getGroupName();
    }


    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
