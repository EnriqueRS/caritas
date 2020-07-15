package net.dynu.dovecot.caritas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DayBehavior {
	@Id
	private Integer id;
	private Integer face;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFace() {
		return face;
	}

	public void setFace(Integer face) {
		this.face = face;
	}
}
