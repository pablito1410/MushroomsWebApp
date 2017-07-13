package pl.polsl.mushrooms.application.model;


import pl.polsl.mushrooms.application.enums.UserRole;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

	public Admin() { }

	@Override
	@Enumerated(EnumType.STRING)
	public UserRole getRole() {
		return UserRole.ADMIN;
	}

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