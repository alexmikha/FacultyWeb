package faculty.servlet;

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
 * Created by Mi on 11.11.2016.
 */
@WebServlet(urlPatterns = "/groups")
public class GroupServlet extends HttpServlet{

    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

    private ApplicationContext applicationContext;
    private ManagerService managerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        applicationContext = (ApplicationContext) getServletContext()
                .getAttribute("app-faculty-context");
        managerService = applicationContext.getBean(ManagerService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("group", managerService.getAllGroups());
            req.getRequestDispatcher("WEB-INF/pages/group.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorTitle", "ERROR");
            req.setAttribute("errorMsg", e);
            req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);

        }
    }
}
