package student;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ItalianCourses")
public class ItalianAdvancedCourse extends AdvancedCourse {

	public ItalianAdvancedCourse(){}
	
	public ItalianAdvancedCourse(String courseName, boolean bachelor){
		this.setCourseName(courseName);
		this.setBachelor(bachelor);
		this.setLanguage("italian");
	}
	
}
