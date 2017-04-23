package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "Comment")
public class Comment extends Commentable implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	protected UUID id;
	private String contents;
	private Date date;
	private Time time;

	@OneToOne
	private Comment target;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "answers")
	private Set<Comment> answers;

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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


//	public void setTarget(Commentable target) {
//		this.target = target;
//	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Comment> getAnswers() {
		throw new UnsupportedOperationException();
	}

	public void setAnswers(Set<Comment> answers) {
		throw new UnsupportedOperationException();
	}

//	public void setTarget(Comment target) {
//		this.target = target;
//	}

	public int hashCode() {
		int hashCode = 0;
		if ( this.id != null ) {
			hashCode += this.id.hashCode();
		}
		if ( this.contents != null ) {
			hashCode += this.contents.hashCode();
		}
		if ( this.date != null ) {
			hashCode += this.date.hashCode();
		}
		if ( this.time != null ) {
			hashCode += this.time.hashCode();
		}
//		if ( this.target != null ) {
//			hashCode += this.target.hashCode();
//		}
		if ( this.user != null ) {
			hashCode += this.user.hashCode();
		}
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Comment) {
			Comment commentObject = (Comment) object;
			boolean equals = true;
			equals &= ((this.id == commentObject.id)
				|| (this.id != null && this.id.equals(commentObject.id)));
			equals &= ((this.contents == commentObject.contents)
				|| (this.contents != null && this.contents.equals(commentObject.contents)));
			equals &= ((this.date == commentObject.date)
				|| (this.date != null && this.date.equals(commentObject.date)));
			equals &= ((this.time == commentObject.time)
				|| (this.time != null && this.time.equals(commentObject.time)));
//			equals &= ((this.target == commentObject.target)
//				|| (this.target != null && this.target.equals(commentObject.target)));
			equals &= ((this.user == commentObject.user)
				|| (this.user != null && this.user.equals(commentObject.user)));
			equals &= this.answers == commentObject.answers;
			return equals;
		}
		return false;
	}
}