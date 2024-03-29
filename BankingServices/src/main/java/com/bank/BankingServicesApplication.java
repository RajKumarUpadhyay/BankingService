package com.bank;


import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.omg.IOP.TransactionService;

import com.bank.money.transfer.dao.DAOFactory;
import com.bank.money.transfer.services.BankingServices;
import com.bank.money.transfer.services.ServiceExceptionMapper;
import com.bank.money.transfer.services.UserService;

/**
 * Main Class (Starting point) 
 */
public class BankingServicesApplication {

	private static Logger log = Logger.getLogger(BankingServicesApplication.class);

	public static void main(String[] args) throws Exception {
		log.info("Initialize demo .....");
		DAOFactory h2DaoFactory = DAOFactory.getDAOFactory(DAOFactory.H2);
		h2DaoFactory.populateTestData();
		log.info("Initialisation Complete....");
		startService();
	}

	private static void startService() throws Exception {
		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/*");
		servletHolder.setInitParameter("jersey.config.server.provider.classnames",
				UserService.class.getCanonicalName() + "," + BankingServices.class.getCanonicalName() + ","
						+ ServiceExceptionMapper.class.getCanonicalName() + ","
						+ TransactionService.class.getCanonicalName());
		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}

}
