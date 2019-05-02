package setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import dao.AirportDao;
import dao.RouteDao;
import tables.Airport;
import tables.Route;

public class RouteSetup implements Setup {
	RouteDao routeDao = new RouteDao();

	@Override
	public void tableSetup() {
		try {

			String s;
			String airlineIata;
			int airlineId;
			String sourceAirportIata;
			int sourceAirportId;
			String destinationAirportIata;
			int destinationAirportId;
			String routeCodeshare;
			String routeStops;
			String routePlaneType;
			Reader reader = new FileReader("routes.dat");
			BufferedReader bufferedReader = new BufferedReader(reader);

			s = bufferedReader.readLine();
			while (s != null) {
				Route route = new Route();
				int counter = 1;
				System.out.println("Whole Line: " + s);
				s = s.replace("\"", "");
				System.out.println("New Whole Line: " + s);

				while (counter <= 14) {

					switch (counter) {
					case 1:
						airlineIata = s.substring(0, s.indexOf(","));
						route.setAirlineIata(airlineIata);
						break;
					case 2:
						airlineId = Integer.parseInt(s.substring(0, s.indexOf(",")).replace("\\N", "-1"));
						route.setAirlineId(airlineId);
						break;
					case 3:
						sourceAirportIata = s.substring(0, s.indexOf(","));
						route.setSourceAirportIata(sourceAirportIata);
						break;
					case 4:
						sourceAirportId = Integer.parseInt(s.substring(0, s.indexOf(",")).replace("\\N", "-1"));
						route.setSourceAirportId(sourceAirportId);
						break;
					case 5:
						destinationAirportIata = s.substring(0, s.indexOf(","));
						route.setDestinationAirportIata(destinationAirportIata);
						break;
					case 6:
						destinationAirportId = Integer.parseInt(s.substring(0, s.indexOf(",")).replace("\\N", "-1"));
						route.setDestinationAirportId(destinationAirportId);
						break;
					case 7:
						routeCodeshare = s.substring(0, s.indexOf(","));
						route.setRouteCodeshare(routeCodeshare);
						break;
					case 8:
						routeStops = s.substring(0, s.indexOf(","));
						route.setRouteStops(routeStops);
						break;
					case 9:
						routePlaneType = s;
						route.setRoutePlaneType(routePlaneType);
						break;
				
					}
					s = s.substring(s.indexOf(",") + 1);
					System.out.println(s);
					counter++;
				}
				routeDao.addRecord(route);
				s = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("oh no 1");
		} catch (IOException e) {
			System.out.println("oh no 2");
		}

	}

	@Override
	public void closeDao() {
		routeDao.closeDao();
	}

}
