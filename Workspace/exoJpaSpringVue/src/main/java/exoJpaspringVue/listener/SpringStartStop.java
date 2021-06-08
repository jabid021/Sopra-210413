package exoJpaspringVue.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoJpaSpring.config.AppConfig;

/**
 * Application Lifecycle Listener implementation class MonListener
 *
 */
@WebListener
public class SpringStartStop implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public SpringStartStop() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		((AnnotationConfigApplicationContext)sce.getServletContext().getAttribute("spring")).close();
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		sce.getServletContext().setAttribute("spring", ctx);
	}

}
