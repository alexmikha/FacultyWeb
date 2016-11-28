package faculty.dto;

import faculty.model.Teacher;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 07.11.2016.
 */
@XmlRootElement(name = "teacher")
public class TeacherDTO {

    private int id;
    private String teacherName;
    private int experience;
    private String subjectName;

    public TeacherDTO() {
    }


    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.teacherName = teacher.getTeacherName();
        this.experience = teacher.getExperience();
        this.subjectName = teacher.getSubject().getSubjectName();
    }

    public TeacherDTO(int id, String teacherName, int experience, String subjectName) {
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", experience=" + experience +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
