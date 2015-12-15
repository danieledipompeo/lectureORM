package student;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EnglishCourses")
public class EnglishAdvancedCourse extends AdvancedCourse {

	public EnglishAdvancedCourse(){}
	
	public EnglishAdvancedCourse(String courseName, boolean bachelor){
		this.setCourseName(courseName);
		this.setBachelor(bachelor);
		this.setLanguage("english");
	}
	
}
