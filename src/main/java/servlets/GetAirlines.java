package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.AirlineDao;
import tables.Airline;

public class GetAirlines extends HttpServlet {
	Logger logger = LogManager.getLogger();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) this.getServletContext().getAttribute("entityManagerFactory");
		AirlineDao airlineDao = new AirlineDao(entityManagerFactory);
		
		List<Airline> airlineList = airlineDao.returnAllRecords(); 
		req.setAttribute("airlines", airlineList );
		req.getRequestDispatcher("./WEB-INF/allAirlines.jsp").forward(req,resp);
	}

}
