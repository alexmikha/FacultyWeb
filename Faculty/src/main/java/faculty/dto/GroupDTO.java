package faculty.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 10.11.2016.
 */

@XmlRootElement(name = "Group")
public class GroupDTO {

    private String name;
    private StudentList studentsList;

    public GroupDTO() {
    }

    public GroupDTO(String name, StudentList studentsList) {
        this.name = name;
        this.studentsList = studentsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentList getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(StudentList studentsList) {
        this.studentsList = studentsList;
    }
}
