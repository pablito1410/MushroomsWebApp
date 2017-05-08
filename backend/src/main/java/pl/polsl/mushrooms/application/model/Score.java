package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "SCORES")
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SCORE_ID")
	private UUID id;

	@Column(name = "VALUE", nullable = false)
	private int value;

	@Column(name = "DATE", nullable = false)
	private Date date;

	@Column(name = "TIME", nullable = false)
	private Time time;

	@ManyToOne(optional = false)
	private Discovery discovery;

	@ManyToOne(optional = false)
	private Mushroomer mushroomer;

	protected Score() { }

	public Score(int value, Date date, Time time, Discovery discovery, Mushroomer mushroomer) {
		this.value = value;
		this.date = date;
		this.time = time;
		this.discovery = discovery;
		this.mushroomer = mushroomer;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Discovery getDiscovery() {
		return this.discovery;
	}

	public void setDiscovery(Discovery discovery) {
		this.discovery = discovery;
	}

	public User getUser() {
		throw new UnsupportedOperationException();
	}

	public void setUser(User user) {
		throw new UnsupportedOperationException();
	}

	public Mushroomer getMushroomer() {
		return this.mushroomer;
	}

	public void setMushroomer(Mushroomer mushroomer) {
		this.mushroomer = mushroomer;
	}

	public int hashCode() {
		int hashCode = 0;
		if ( this.id != null ) {
			hashCode += this.id.hashCode();
		}
		if ( this.date != null ) {
			hashCode += this.date.hashCode();
		}
		if ( this.time != null ) {
			hashCode += this.time.hashCode();
		}
		if ( this.discovery != null ) {
			hashCode += this.discovery.hashCode();
		}
		if ( this.mushroomer != null ) {
			hashCode += this.mushroomer.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Score) {
			Score scoreObject = (Score) object;
			boolean equals = true;
			equals &= ((this.id == scoreObject.id)
				|| (this.id != null && this.id.equals(scoreObject.id)));
			equals &= this.value == scoreObject.value;
			equals &= ((this.date == scoreObject.date)
				|| (this.date != null && this.date.equals(scoreObject.date)));
			equals &= ((this.time == scoreObject.time)
				|| (this.time != null && this.time.equals(scoreObject.time)));
			equals &= ((this.discovery == scoreObject.discovery)
				|| (this.discovery != null && this.discovery.equals(scoreObject.discovery)));
			equals &= ((this.mushroomer == scoreObject.mushroomer)
				|| (this.mushroomer != null && this.mushroomer.equals(scoreObject.mushroomer)));
			return equals;
		}
		return false;
	}
}