package academy.learnprogramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET= "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
            log.info("On Startup");

//  Creating Spring Application Context:
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

//  Create Dispatcher Servlet:
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

//  Register and Configure Dispatcher Servler
        ServletRegistration.Dynamic registration =
                servletContext.addServlet(DISPATCHER_SERVLET, dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
