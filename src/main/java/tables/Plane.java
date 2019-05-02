package tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plane implements Record {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int planeId;
	String planeName;
	String planeIata;
	String planeIcao;
	
	public Plane() {
		super();
	}
	
	public Plane(String planeName, String planeIata, String planeIcao) {
		super();
		this.planeName = planeName;
		this.planeIata = planeIata;
		this.planeIcao = planeIcao;
	}
	public int getPlaneId() {
		return planeId;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getPlaneIata() {
		return planeIata;
	}

	public void setPlaneIata(String planeIata) {
		this.planeIata = planeIata;
	}

	public String getPlaneIcao() {
		return planeIcao;
	}

	public void setPlaneIcao(String planeIcao) {
		this.planeIcao = planeIcao;
	}
}
