package tables;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airline implements Record {
	@Id
	private int id;	
	private String name;
	private String alias;
	private String iataCode;
	private String icaoCode;
	private String callsign;
	private String country;
	private String operationalStatus;
	
	public Airline() {
		super();
	}
	
	public Airline(int id, String name, String alias, String iataCode, String icaoCode, String callsign, String country,
			String operationalStatus) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.iataCode = iataCode;
		this.icaoCode = icaoCode;
		this.callsign = callsign;
		this.country = country;
		this.operationalStatus = operationalStatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	public String getIcaoCode() {
		return icaoCode;
	}
	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}
	public String getCallsign() {
		return callsign;
	}
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOperationalStatus() {
		return operationalStatus;
	}
	public void setOperationalStatus(String operationalStatus) {
		this.operationalStatus = operationalStatus;
	}
	
}
