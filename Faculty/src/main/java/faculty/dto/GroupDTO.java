package faculty.dto;

import faculty.model.Group;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 10.11.2016.
 */

@XmlRootElement(name = "Group")
public class GroupDTO {

    private int id;
    private String groupName;
    private StudentList studentsList;

    public GroupDTO() {
    }

    public GroupDTO(String groupName, StudentList studentsList) {
        this.groupName = groupName;
        this.studentsList = studentsList;
    }

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.groupName = group.getGroupName();
        this.studentsList = (StudentList) group.getStudentSet();
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public StudentList getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(StudentList studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", studentsList=" + studentsList +
                '}';
    }
}
