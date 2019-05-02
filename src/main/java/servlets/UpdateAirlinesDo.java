package servlets;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AirlineDao;
import tables.Airline;



public class UpdateAirlinesDo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./WEB-INF/updateAirlineDo.jsp");
		requestDispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) this.getServletContext()
				.getAttribute("entityManagerFactory");
		AirlineDao airlineDao = new AirlineDao(entityManagerFactory);
		int i=0;
		String[] ids = req.getParameterValues("id");
		String[] names = req.getParameterValues("name");
		String[] aliases = req.getParameterValues("alias");
		String[] iatas = req.getParameterValues("iataCode");
		String[] icaos = req.getParameterValues("icaoCode");
		String[] callsigns = req.getParameterValues("callsign");
		String[] countries = req.getParameterValues("country");
		String[] ops = req.getParameterValues("operationalStatus");
		
		while(i<ids.length) {
			airlineDao.updateRecord(new Airline(Integer.parseInt(ids[i]),names[i],aliases[i],iatas[i],icaos[i],callsigns[i],countries[i],ops[i]));
			i++;
		}
		
		
		req.getRequestDispatcher("./WEB-INF/updateAirlineSuccess.jsp").forward(req, resp);
	}
}
