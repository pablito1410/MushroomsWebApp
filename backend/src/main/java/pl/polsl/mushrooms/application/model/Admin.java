package pl.polsl.mushrooms.application.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
@DiscriminatorValue("Admin")
public class Admin extends User {

	public int hashCode() {
		int hashCode = 0;
		if ( hashCode == 0 ) {
			hashCode = super.hashCode();
		}
		return hashCode;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		} else if (object instanceof Admin) {
			Admin adminObject = (Admin) object;
			boolean equals = true;
			return equals;
		}
		return false;
	}
}