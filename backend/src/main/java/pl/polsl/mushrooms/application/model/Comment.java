package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "COMMENTS")
public class Comment extends Commentable{

	@Column(name = "CONTENTS", nullable = false)
	private String contents;

	@Column(name = "DATE_TIME", nullable = false)
	private LocalDateTime dateTime;

	@OneToOne(optional = false)
	private Commentable target;

	@ManyToOne(optional = false)
	private User user;

	@OneToMany(mappedBy = "answers")
	private Set<Comment> answers;

	protected Comment() {
		answers = new HashSet<>();
	}

	public Comment(String contents, LocalDateTime dateTime, Commentable target, User user) {
		this();
		this.contents = contents;
		this.dateTime = dateTime;
		this.dateTime = dateTime;
		this.target = target;
		this.user = user;
	}

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

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Commentable getTarget() {
		return target;
	}

	public void setTarget(Commentable target) {
		this.target = target;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Comment> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Comment> answers) {
		this.answers = answers;
	}

	public int hashCode() {
		int hashCode = 0;
		if ( this.id != null ) {
			hashCode += this.id.hashCode();
		}
		if ( this.contents != null ) {
			hashCode += this.contents.hashCode();
		}
		if ( this.dateTime != null ) {
			hashCode += this.dateTime.hashCode();
		}
		if ( this.target != null ) {
			hashCode += this.target.hashCode();
		}
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
			equals &= ((this.dateTime == commentObject.dateTime)
				|| (this.dateTime != null && this.dateTime.equals(commentObject.dateTime)));
			equals &= ((this.target == commentObject.target)
				|| (this.target != null && this.target.equals(commentObject.target)));
			equals &= ((this.user == commentObject.user)
				|| (this.user != null && this.user.equals(commentObject.user)));
			equals &= this.answers == commentObject.answers;
			return equals;
		}
		return false;
	}

}