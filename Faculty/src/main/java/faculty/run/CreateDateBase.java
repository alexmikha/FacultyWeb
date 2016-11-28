package faculty.run;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mi on 06.10.2016.
 */
public class CreateDateBase {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        EntityManagerFactory managerFaculty = Persistence.
                createEntityManagerFactory("faculty_hibernate");
    }
}
