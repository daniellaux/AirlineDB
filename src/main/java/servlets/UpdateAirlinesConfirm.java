package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AirlineDao;
import tables.Airline;

public class UpdateAirlinesConfirm extends HttpServlet{
	
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
		List<Airline> airlineList = new ArrayList<Airline>();
	

		String[] selectedAirlines = req.getParameterValues("selectedAirline");
		for (String value : selectedAirlines) {
			airlineList.add(airlineDao.getRecordById(new Airline(Integer.parseInt(value), "", "", "", "", "", "", "")));
		}

		req.setAttribute("airlineList", airlineList);
		req.getRequestDispatcher("./WEB-INF/updateAirlineDo.jsp").forward(req, resp);
	}
}
