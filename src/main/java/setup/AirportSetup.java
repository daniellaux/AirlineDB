package setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import dao.AirportDao;
import tables.Airport;

public class AirportSetup implements Setup {
	AirportDao airportDao = new AirportDao();

	@Override
	public void tableSetup() {
		try {

			String s;
			int airportId;	
			String airportName;
			String airportCity;
			String airportCountry;
			String airportIata;
			String airportIcao;
			String airportLatitude;
			String airportLongitude;
			String airportAltitude;
			String airportTimezone;
			String airportDst;
			String airportDbTimezone;
			String airportType;
			String airportSource;
			Reader reader = new FileReader("airports.dat");
			BufferedReader bufferedReader = new BufferedReader(reader);

			s = bufferedReader.readLine();
			while (s != null) {
				Airport airport = new Airport();
				int counter = 1;
				System.out.println("Whole Line: " + s);
				s = s.replace("\"", "");
				System.out.println("New Whole Line: " + s);

				while (counter <= 14) {

					switch (counter) {
					case 1:
						airportId = Integer.parseInt(s.substring(0, s.indexOf(",")));
						airport.setAirportId(airportId);
						break;
					case 2:
						airportName = s.substring(0, s.indexOf(","));
						airport.setAirportName(airportName);
						break;
					case 3:
						airportCity = s.substring(0, s.indexOf(","));
						airport.setAirportCity(airportCity);
						break;
					case 4:
						airportCountry = s.substring(0, s.indexOf(","));
						airport.setAirportIata(airportCountry);
						break;
					case 5:
						airportIata = s.substring(0, s.indexOf(","));
						airport.setAirportIata(airportIata);
						break;
					case 6:
						airportIcao = s.substring(0, s.indexOf(","));
						airport.setAirportIcao(airportIcao);
						break;
					case 7:
						airportLatitude = s.substring(0, s.indexOf(","));
						airport.setAirportLatitude(airportLatitude);
						break;
					case 8:
						airportLongitude = s.substring(0, s.indexOf(","));
						airport.setAirportLongitude(airportLongitude);
						break;
					case 9:
						airportAltitude = s.substring(0, s.indexOf(","));
						airport.setAirportAltitude(airportAltitude);
						break;
					case 10:
						airportTimezone = s.substring(0, s.indexOf(","));
						airport.setAirportTimezone(airportTimezone);
						break;
					case 11:
						airportDst = s.substring(0, s.indexOf(","));
						airport.setAirportDst(airportDst);
						break;
					case 12:
						airportDbTimezone = s.substring(0, s.indexOf(","));
						airport.setAirportDbTimezone(airportDbTimezone);
						break;
					case 13:
						airportType = s.substring(0, s.indexOf(","));
						airport.setAirportType(airportType);
						break;
					case 14:
						airportSource = s;
						airport.setAirportAltitude(airportSource);
						break;
					}
					s = s.substring(s.indexOf(",") + 1);
					System.out.println(s);
					counter++;
				}
				airportDao.addRecord(airport);
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
		airportDao.closeDao();
	}

}
