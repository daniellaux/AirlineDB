package listeners;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class JpaListener implements ServletContextListener {
	private static EntityManagerFactory entityManagerFactory;
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
		} 	
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		entityManagerFactory = Persistence.createEntityManagerFactory("oraclePersistence");
		servletContextEvent.getServletContext().setAttribute("entityManagerFactory", entityManagerFactory);
	}

}
