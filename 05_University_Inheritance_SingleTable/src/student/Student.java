package student;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Student")
public class Student extends Person{

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TranscriptID")
	private Transcript transcript;

	@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "Students_Courses", joinColumns = @JoinColumn(name = "Student_ID") , inverseJoinColumns = @JoinColumn(name = "Course_ID") )
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {
	}

	public Student(String studentName, Transcript transcript, Address studentAddress,
			Set<Course> courses) {
		this.name = studentName;
		this.transcript = transcript;
		this.setPersonAddress(studentAddress);
		this.courses = courses;
	}

	public Transcript getTranscript() {
		return this.transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
