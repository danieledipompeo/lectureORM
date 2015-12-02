package student;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Students")
@AttributeOverrides({
	@AttributeOverride(name="personAddress", column=@Column(name="AddressID")),
	@AttributeOverride(name="name", column=@Column(name="Name")),
})
public class Student extends Person{
	
//	@Id
//	@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long studentId;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TranscriptID")
	private Transcript transcript;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

	@ManyToMany(targetEntity = Course.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "Students_Courses", joinColumns = @JoinColumn(name = "Student_ID") , inverseJoinColumns = @JoinColumn(name = "Course_ID") )
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {
	}

	public Student(String studentName, Transcript transcript, Set<Phone> studentPhoneNumbers, Address studentAddress,
			Set<Course> courses) {
		this.name = studentName;
		this.transcript = transcript;
		this.studentPhoneNumbers = studentPhoneNumbers;
		this.setPersonAddress(studentAddress);
		this.courses = courses;
	}

	public Transcript getTranscript() {
		return this.transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public Set<Phone> getStudentPhoneNumbers() {
		return this.studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}

	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
