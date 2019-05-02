package tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Route implements Record{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int routeId;
	String airlineIata;
	int airlineId;
	String sourceAirportIata;
	int sourceAirportId;
	String destinationAirportIata;
	int destinationAirportId;
	String routeCodeshare;
	String routeStops;
	String routePlaneType;
	
	public Route() {
		super();
	}

	public Route(String airlineIata, int airlineId, String sourceAirportIata, int sourceAirportId,
			String destinationAirportIata, int destinationAirportId, String routeCodeshare, String routeStops,
			String routePlaneType) {
		super();
		this.airlineIata = airlineIata;
		this.airlineId = airlineId;
		this.sourceAirportIata = sourceAirportIata;
		this.sourceAirportId = sourceAirportId;
		this.destinationAirportIata = destinationAirportIata;
		this.destinationAirportId = destinationAirportId;
		this.routeCodeshare = routeCodeshare;
		this.routeStops = routeStops;
		this.routePlaneType = routePlaneType;
	}
	public int getRouteId() {
		return routeId;
	}
	
	public String getAirlineIata() {
		return airlineIata;
	}
	public void setAirlineIata(String airlineIata) {
		this.airlineIata = airlineIata;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public String getSourceAirportIata() {
		return sourceAirportIata;
	}
	public void setSourceAirportIata(String sourceAirportIata) {
		this.sourceAirportIata = sourceAirportIata;
	}
	public int getSourceAirportId() {
		return sourceAirportId;
	}
	public void setSourceAirportId(int sourceAirportId) {
		this.sourceAirportId = sourceAirportId;
	}
	public String getDestinationAirportIata() {
		return destinationAirportIata;
	}
	public void setDestinationAirportIata(String destinationAirportIata) {
		this.destinationAirportIata = destinationAirportIata;
	}
	public int getDestinationAirportId() {
		return destinationAirportId;
	}
	public void setDestinationAirportId(int destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}
	public String getRouteCodeshare() {
		return routeCodeshare;
	}
	public void setRouteCodeshare(String routeCodeshare) {
		this.routeCodeshare = routeCodeshare;
	}
	public String getRouteStops() {
		return routeStops;
	}
	public void setRouteStops(String routeStops) {
		this.routeStops = routeStops;
	}
	public String getRoutePlaneType() {
		return routePlaneType;
	}
	public void setRoutePlaneType(String routePlaneType) {
		this.routePlaneType = routePlaneType;
	}
}
