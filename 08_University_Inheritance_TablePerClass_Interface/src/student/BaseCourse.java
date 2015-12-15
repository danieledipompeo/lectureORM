package student;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BaseCourses")
public class BaseCourse extends Course{
	
	public BaseCourse(){}
	
	public BaseCourse(String courseName) {
		this.courseName = courseName;
		this.setBachelor(true); 
	}

}
