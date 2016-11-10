package faculty.servlet;

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

/**
 * Created by Mi on 07.11.2016.
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

    private ApplicationContext applicationContext;
    private ManagerService managerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
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
            //current localhost:8080/testio/register
            // Absolute path  = /http/error.jsp localhost:8080/http/error
            // Relative path = http/error.jsp localhost:8080/testio/http/error.jsp
        } else {
            Student student = new Student(name, new Group(""));

            Student created = managerService.createStudent(student);
            req.setAttribute("student", created);
            req.getRequestDispatcher("/WEB-INF/pages/student-info.jsp").forward(req, resp);
        }
    }
}
