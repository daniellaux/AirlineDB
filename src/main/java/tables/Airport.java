package tables;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport implements Record {
	@Id
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
	
	
	
	public Airport() {
		super();
		
	}


	public Airport(int airportId, String airportName, String airportCity, String airportCountry, String airportIata,
			String airportIcao, String airportLatitude, String airportLongitude, String airportAltitude,
			String airportTimezone, String airportDst, String airportDbTimezone, String aiportType,
			String airportSource) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.airportCity = airportCity;
		this.airportCountry = airportCountry;
		this.airportIata = airportIata;
		this.airportIcao = airportIcao;
		this.airportLatitude = airportLatitude;
		this.airportLongitude = airportLongitude;
		this.airportAltitude = airportAltitude;
		this.airportTimezone = airportTimezone;
		this.airportDst = airportDst;
		this.airportDbTimezone = airportDbTimezone;
		this.airportType = aiportType;
		this.airportSource = airportSource;
	}
	
	
	public int getAirportId() {
		return airportId;
	}
	public void setAirportId(int airportId) {
		this.airportId = airportId;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCity() {
		return airportCity;
	}
	public void setAirportCity(String airportCity) {
		this.airportCity = airportCity;
	}
	public String getAirportCountry() {
		return airportCountry;
	}
	public void setAirportCountry(String airportCountry) {
		this.airportCountry = airportCountry;
	}
	public String getAirportIata() {
		return airportIata;
	}
	public void setAirportIata(String airportIata) {
		this.airportIata = airportIata;
	}
	public String getAirportIcao() {
		return airportIcao;
	}
	public void setAirportIcao(String airportIcao) {
		this.airportIcao = airportIcao;
	}
	public String getAirportLatitude() {
		return airportLatitude;
	}
	public void setAirportLatitude(String airportLatitude) {
		this.airportLatitude = airportLatitude;
	}
	public String getAirportLongitude() {
		return airportLongitude;
	}
	public void setAirportLongitude(String airportLongitude) {
		this.airportLongitude = airportLongitude;
	}
	public String getAirportAltitude() {
		return airportAltitude;
	}
	public void setAirportAltitude(String airportAltitude) {
		this.airportAltitude = airportAltitude;
	}
	public String getAirportTimezone() {
		return airportTimezone;
	}
	public void setAirportTimezone(String airportTimezone) {
		this.airportTimezone = airportTimezone;
	}
	public String getAirportDst() {
		return airportDst;
	}
	public void setAirportDst(String airportDst) {
		this.airportDst = airportDst;
	}
	public String getAirportDbTimezone() {
		return airportDbTimezone;
	}
	public void setAirportDbTimezone(String airportDbTimezone) {
		this.airportDbTimezone = airportDbTimezone;
	}
	public String getAirportType() {
		return airportType;
	}
	public void setAirportType(String airportType) {
		this.airportType = airportType;
	}
	public String getAirportSource() {
		return airportSource;
	}
	public void setAirportSource(String airportSource) {
		this.airportSource = airportSource;
	}
}
