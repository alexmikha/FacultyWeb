package faculty.servlet;

import faculty.model.Subject;
import faculty.model.Teacher;
import faculty.service.ManagerService;
import faculty.service.ManagerServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mi on 09.11.2016.
 */

@WebServlet(urlPatterns = "/teachers")
public class TeachersServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(SubjectsServlet.class);

    private ApplicationContext applicationContext;
    private ManagerService managerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("app-faculty-context");
        managerService = applicationContext.getBean(ManagerServiceImpl.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("teachers", managerService.getAllTeachers());
            req.getRequestDispatcher("WEB-INF/pages/teacher.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorTitle", "ERROR");
            req.setAttribute("errorMsg", e);
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("teacherName");
        int expr = Integer.parseInt(req.getParameter("experience"));
        String subjectName = req.getParameter("subject");
        String subjectDesc = req.getParameter("desc");

        try {
            Teacher teacher = new Teacher(name, expr, new Subject(subjectName));

            Teacher created = managerService.addTeacher(teacher);
            req.setAttribute("teacher", created);
            req.getRequestDispatcher("/WEB-INF/pages/teacher.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
    }
}
