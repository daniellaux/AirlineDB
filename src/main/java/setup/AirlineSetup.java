package setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import dao.AirlineDao;
import tables.Airline;

public class AirlineSetup implements Setup {
	AirlineDao airlineDao = new AirlineDao();

	@Override
	public void tableSetup() {
		try {

			String s;
			int airlineId;
			String icao;
			String iata;
			String airlineName;
			String airlineAlias;
			String callSign;
			String country;
			String opStatus;
			Reader reader = new FileReader("airlines.dat");
			BufferedReader bufferedReader = new BufferedReader(reader);

			s = bufferedReader.readLine();
			while (s != null) {
				Airline airline = new Airline();
				int counter = 1;
				System.out.println("Whole Line: " + s);
				s = s.replace("\"", "");
				System.out.println("New Whole Line: " + s);

				while (counter <= 8) {

					switch (counter) {
					case 1:
						airlineId = Integer.parseInt(s.substring(0, s.indexOf(",")));
//						System.out.println("id: " + airlineId);
						airline.setId(airlineId);
						break;
					case 2:
						airlineName = s.substring(0, s.indexOf(","));
//						System.out.println("airlineName: " + airlineName);
						airline.setName(airlineName);
						break;
					case 3:
						airlineAlias = s.substring(0, s.indexOf(","));
//						System.out.println("airlineAlias: " + airlineAlias);
						airline.setAlias(airlineAlias);
						break;
					case 4:
						iata = s.substring(0, s.indexOf(","));
//						System.out.println("iata: " + iata);
						airline.setIataCode(iata);
						break;
					case 5:
						icao = s.substring(0, s.indexOf(","));
//						System.out.println("icao: " + icao);
						airline.setIcaoCode(icao);
						break;
					case 6:
						callSign = s.substring(0, s.indexOf(","));
//						System.out.println("callsign: " + callSign);
						airline.setCallsign(callSign);
						break;
					case 7:
						country = s.substring(0, s.indexOf(","));
//						System.out.println("country: " + country);
						airline.setCountry(country);
						break;
					case 8:
						opStatus = s;
//						System.out.println("opStatus: " + opStatus);
						airline.setOperationalStatus(opStatus);
						break;
					}
					s = s.substring(s.indexOf(",") + 1);
					System.out.println(s);
					counter++;
				}
				airlineDao.addRecord(airline);
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
		airlineDao.closeDao();
	}

}
