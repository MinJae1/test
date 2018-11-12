package jspbook.ch14;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogContextListener implements ServletContextListener {
	Logger LOG;

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		LOG.info("LogContextListener start");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		LOG = LoggerFactory.getLogger(this.getClass());
		LOG.info("LogContextListener start");
	}

}
