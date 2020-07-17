package net.dynu.dovecot.caritas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DayBehavior {

	@Id
	private Integer id;
	private Integer face;
	private Date date;

	public DayBehavior(){

	}

	public DayBehavior(Integer id, Integer face, Date date) {
		this.id = id;
		this.date = date;
		this.face = face;
	}
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
