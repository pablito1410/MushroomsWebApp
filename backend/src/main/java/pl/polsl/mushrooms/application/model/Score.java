package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "SCORES")
public class Score implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "SCORE_ID")
	private long id;

	@Column(name = "VALUE", nullable = false)
	private int value;

//	@Column(name = "DATE_TIME", nullable = false)
//	private LocalDateTime dateTime;

	@ManyToOne(optional = false)
	private Discovery discovery;

	@ManyToOne(optional = false)
	private Mushroomer mushroomer;

	protected Score() { }

	public Score(int value, LocalDateTime dateTime, Discovery discovery, Mushroomer mushroomer) {
		this.value = value;
//		this.dateTime = dateTime;
		this.discovery = discovery;
		this.mushroomer = mushroomer;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

//	public LocalDateTime getDateTime() {
//		return this.dateTime;
//	}

//	public void setDateTime(LocalDateTime dateTime) {
//		this.dateTime = dateTime;
//	}

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
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
//		if ( this.dateTime != null ) {
//			hashCode += this.dateTime.hashCode();
//		}
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
				|| (this.id == scoreObject.id));
			equals &= this.value == scoreObject.value;
//			equals &= ((this.dateTime == scoreObject.dateTime)
//				|| (this.dateTime != null && this.dateTime.equals(scoreObject.dateTime)));
			equals &= ((this.discovery == scoreObject.discovery)
				|| (this.discovery != null && this.discovery.equals(scoreObject.discovery)));
			equals &= ((this.mushroomer == scoreObject.mushroomer)
				|| (this.mushroomer != null && this.mushroomer.equals(scoreObject.mushroomer)));
			return equals;
		}
		return false;
	}
}