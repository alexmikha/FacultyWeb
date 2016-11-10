package faculty.runSoapServer;

import faculty.service.ManagerService;
import faculty.soap.endpoint.StudentEndpointImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.ws.Endpoint;

/**
 * Created by Mi on 09.11.2016.
 */
public class StartSoapServer {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("app-faculty-context.xml");
        ManagerService managerService = appCon.getBean(ManagerService.class);


        Endpoint.publish(
                "http://localhost:9999/soap/test", new StudentEndpointImpl(managerService));

    }
}

