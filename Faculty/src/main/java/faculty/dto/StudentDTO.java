package faculty.dto;

import faculty.model.Group;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 7.11.16.
 */
@XmlRootElement(name = "student")
public class StudentDTO {


    private int id;
    private String name;
    private Group group;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }
}
