package setup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import dao.PlaneDao;
import tables.Plane;

public class PlaneSetup implements Setup {
	PlaneDao planeDao = new PlaneDao();

	@Override
	public void tableSetup() {
		try {

			String s;
			String planeName;
			String planeIata;
			String planeIcao;

			Reader reader = new FileReader("planes.dat");
			BufferedReader bufferedReader = new BufferedReader(reader);

			s = bufferedReader.readLine();
			while (s != null) {
				Plane plane = new Plane();
				int counter = 1;
				System.out.println("Whole Line: " + s);
				s = s.replace("\"", "");
				System.out.println("New Whole Line: " + s);

				while (counter <= 3) {

					switch (counter) {
					case 1:
						planeName = s.substring(0, s.indexOf(","));
						plane.setPlaneName(planeName);
						break;
					case 2:
						planeIata = s.substring(0, s.indexOf(","));
						plane.setPlaneIata(planeIata);
						break;
					case 3:
						planeIcao = s;
						plane.setPlaneIcao(planeIcao);
						break;
					}
					s = s.substring(s.indexOf(",") + 1);
					System.out.println(s);
					counter++;
				}
				planeDao.addRecord(plane);
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
		planeDao.closeDao();
	}

}
