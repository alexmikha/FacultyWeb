package faculty.dto;

import faculty.model.Subject;

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
    private Subject subject;

    public TeacherDTO() {
    }

    public TeacherDTO(int id, String teacherName, int experience, Subject subject) {
        this.id = id;
        this.teacherName = teacherName;
        this.experience = experience;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", experience=" + experience +
                ", subject=" + subject.getSubjectName() +
                '}';
    }
}
