package faculty.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Mi on 7.11.16.
 */

// JAXB
@XmlRootElement(name = "studentsList")
public class StudentList extends StudentDTO {

    private List<StudentDTO> dtoList;

    public StudentList() {
    }

    @XmlElement(name = "student")
    public List<StudentDTO> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<StudentDTO> dtoList) {
        this.dtoList = dtoList;
    }
}
