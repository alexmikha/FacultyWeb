package faculty.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Created by Mi on 7.11.16.
 */
public class InitSpringContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String springLocation = sce.getServletContext().getInitParameter("springLocation");
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(springLocation);

        sce.getServletContext().setAttribute("app-faculty-context",applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
