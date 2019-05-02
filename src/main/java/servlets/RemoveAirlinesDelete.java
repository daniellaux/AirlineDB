package servlets;

import java.io.IOException;

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

public class RemoveAirlinesDelete extends HttpServlet {
	Logger logger = LogManager.getLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./WEB-INF/removeAirlineConfirm.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) this.getServletContext()
				.getAttribute("entityManagerFactory");
		AirlineDao airlineDao = new AirlineDao(entityManagerFactory);

	

		String[] selectedAirlines = req.getParameterValues("selectedAirline");
		for (String value : selectedAirlines) {
			airlineDao.removeRecord(new Airline(Integer.parseInt(value),"temp","temp","temp","temp","temp","temp","temp"));
		}
		// for (int i = 0; i < selectedAirlines.length; i++) {
		//
		// // airlineDao.removeRecord(value);
		// removedList.add(selectedAirlines[i]);
		//
		// }
		req.setAttribute("selectedAirlines", selectedAirlines);
		req.getRequestDispatcher("./WEB-INF/removeAirlineSuccess.jsp").forward(req, resp);
	}
}
