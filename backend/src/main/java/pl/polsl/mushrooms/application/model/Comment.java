package pl.polsl.mushrooms.application.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "\"COMMENTS\"")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"COMMENT_ID\"")
	protected Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "\"DISCOVERY_ID\"")
	private Discovery discovery;

	@Column(name = "\"CONTENT\"", nullable = false)
	private String content;

	@Column(name = "\"DATE_TIME\"", nullable = false)
	private LocalDateTime dateTime;

	@OneToOne(optional = false)
	@JoinColumn(name = "\"TARGET_COMMENT_ID\"", referencedColumnName = "\"COMMENT_ID\"")
	private Comment target;

	@ManyToOne(optional = false)
	@JoinColumn(name = "\"USER_ID\"")
	private User user;

	@OneToMany(mappedBy = "answers")
	private Set<Comment> answers;

	protected Comment() {
		answers = new HashSet<>();
	}

	public Comment(String content, LocalDateTime dateTime, Comment target, User user) {
		this();
		this.content = content;
		this.dateTime = dateTime;
		this.dateTime = dateTime;
		this.target = target;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public Discovery getDiscovery() {
		return discovery;
	}

	public Comment getTargetComment() {
		return target;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
//		if ( this.id != null ) {
//			hashCode += this.id.hashCode();
//		}
		if ( this.content != null ) {
			hashCode += this.content.hashCode();
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
//			equals &= ((this.id == commentObject.id)
//				|| (this.id == commentObject.id));
			equals &= ((this.content == commentObject.content)
				|| (this.content != null && this.content.equals(commentObject.content)));
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