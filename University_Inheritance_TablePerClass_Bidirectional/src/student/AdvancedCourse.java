package student;

import javax.persistence.Entity;

@Entity
public abstract class AdvancedCourse extends Course {

	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	

}
