package student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="ID")
	protected long courseId;
	
	@Column(name="Name")
	protected String courseName;
	
	protected boolean bachelor;
	
	public long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean isBachelor() {
		return bachelor;
	}

	public void setBachelor(boolean bachelor) {
		this.bachelor = bachelor;
	}
	
	public String toString(){
		String str = "";
		str += "course name: "+this.getCourseName()+"\n";
		return str;
	}
}
