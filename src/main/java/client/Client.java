package client;

import dao.AirlineDao;
import setup.AirportSetup;
import setup.PlaneSetup;
import setup.RouteSetup;
import tables.Airline;

public class Client {

	public static void main(String[] args) {
		RouteSetup routeSetup = new RouteSetup();
		routeSetup.tableSetup();
		routeSetup.closeDao();
	}
}
