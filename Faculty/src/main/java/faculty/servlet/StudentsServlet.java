package faculty.servlet;

import com.google.gson.Gson;
import faculty.model.Group;
import faculty.model.Student;
import faculty.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mi on 09.11.2016.
 */
@WebServlet(urlPatterns = {"/students"})
public class StudentsServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(SubjectsServlet.class);

    private ApplicationContext applicationContext;
    private ManagerService managerService;
    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("app-faculty-context");
        managerService = applicationContext.getBean(ManagerService.class);
        gson = applicationContext.getBean(Gson.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("students", managerService.getAllStudents());
            req.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorTitle", "ERROR");
            req.setAttribute("errorMsg", e);
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("studentName");
        String groupName = req.getParameter("groupName");

        Group group = null;

        try {
            List<Group> groups = managerService.getAllGroups();
            for (Group group1 : groups) {
                if (group1.getGroupName().equals(groupName)) {
                    group = group1;
                    group.addStudent(new Student(name, group));
                    managerService.updateGroup(group);
                    Student student = null;
                    String studentName =student.getStudentName();
               //     Student student = managerService.get
                    resp.getWriter().print(studentName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}