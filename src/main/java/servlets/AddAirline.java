package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.AirlineDao;
import tables.Airline;

public class AddAirline extends HttpServlet {

	Logger logger = LogManager.getLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		resp.getWriter().print("This is the response from Do Get");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./WEB-INF/addAirline.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) this.getServletContext()
				.getAttribute("entityManagerFactory");
		AirlineDao airlineDao = new AirlineDao(entityManagerFactory);

		Airline airline = new Airline();
		
		airline.setId(Integer.parseInt(req.getParameter("id")));
		logger.trace("New Airline Id: " + airline.getId());
		airline.setName(req.getParameter("name"));
		logger.trace("New Airline Name: " + airline.getName());
		airline.setAlias(req.getParameter("alias"));
		logger.trace("New Airline Alias: " + airline.getAlias());
		airline.setIataCode(req.getParameter("iataCode"));
		logger.trace("New Airline iataCode: " + airline.getIataCode());
		airline.setIcaoCode(req.getParameter("icaoCode"));
		logger.trace("New Airline icaoCode: " + airline.getIcaoCode());
		airline.setCallsign(req.getParameter("callsign"));
		logger.trace("New Airline Callsign: " + airline.getCallsign());
		airline.setCountry(req.getParameter("country"));
		logger.trace("New Airline Country: " + airline.getCountry());
		airline.setOperationalStatus(req.getParameter("operationalStatus"));
		logger.trace("New Airline Status: " + airline.getOperationalStatus());
		
		Airline temp  = airlineDao.getRecordById(airline);
		
		if(temp==null) {
		
			airlineDao.addRecord(airline);
			logger.trace("New Airline persisted: " + airline.toString());

			req.setAttribute("airline", airline);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./WEB-INF/addAirlineSuccess.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			req.setAttribute("airline", airline);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./WEB-INF/addAirlineExists.jsp");
			requestDispatcher.forward(req, resp);
		}
		
		// resp.getWriter().print("This is the response from Do Post");
	}

}
