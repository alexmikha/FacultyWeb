package faculty.servlet;

import faculty.exception.NoStudentFoundException;
import faculty.model.Student;
import faculty.service.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Mi on 27.10.16.
 */

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        try {
            Student found = managerService.loginStudent(name);

            HttpSession session = req.getSession(true);
            session.setAttribute("inSystem", true);
            session.setAttribute("currentUserName",found.getStudentName());

            resp.sendRedirect("index.jsp");
        } catch (NoStudentFoundException e) {
            req.setAttribute("errorTitle", "Login Error");
            req.setAttribute("errorMessage", "invalid name");
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        }
        // redirect
    }
}