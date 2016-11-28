package faculty.servlet;

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
 * Created by Mi on 09.11.2016.
 */
@WebServlet(urlPatterns = "/subjects")
public class SubjectsServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(SubjectsServlet.class);

    private ApplicationContext applicationContext;
    private ManagerService managerService;

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("app-faculty-context");
        managerService = applicationContext.getBean(ManagerService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("subjects", managerService.getAllSubjects());
            req.getRequestDispatcher("WEB-INF/pages/subject.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorTitle", "ERROR");
            req.setAttribute("errorMsg", e);
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);

        }
    }
}
