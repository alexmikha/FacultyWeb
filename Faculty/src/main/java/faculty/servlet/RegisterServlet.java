package faculty.servlet;

import faculty.exception.RegisterException;
import faculty.model.Group;
import faculty.model.Student;
import faculty.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mi on 07.11.2016.
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

    private ApplicationContext applicationContext;
    private ManagerService managerService;

    @Override
    public void init() throws ServletException {
        applicationContext =
                (ApplicationContext) getServletContext().getAttribute("app-faculty-context");
        managerService = applicationContext.getBean(ManagerService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // just redirect to register.jsp
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // waiting data from the form
        String name = req.getParameter("name");
        String groupStr = req.getParameter("group");

        if (name == null || groupStr == null) {
            // redirect
            resp.sendRedirect("http/error.jsp");
            // Absolute path  = /http/error.jsp localhost:9999/http/error
            // Relative path = http/error.jsp localhost:9999/faculty/http/error.jsp
        } else {
            Student student = new Student(name, new Group(groupStr));

            Student created = null;
            try {
                created = managerService.createStudent(student);
            } catch (RegisterException e) {
                e.printStackTrace();
            }
            req.setAttribute("student", created);
            req.getRequestDispatcher("/WEB-INF/pages/student-info.jsp").forward(req, resp);
        }
    }
}