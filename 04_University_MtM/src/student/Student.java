package student;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long studentId;
	
	@Column(name="Name")
	private String studentName;
	
	@OneToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name="TranscriptID")
	private Transcript transcript;

	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name="AddressID")
	private Address studentAddress;
	
	@ManyToMany
	private Set<Course> courses = new HashSet<Course>(0);

	public Student() {}

	public Student(String studentName, Transcript transcript, Set<Phone> studentPhoneNumbers, Address studentAddress, Set<Course> courses) {
		this.studentName = studentName;
		this.transcript = transcript;
		this.studentPhoneNumbers = studentPhoneNumbers;
		this.studentAddress = studentAddress;
		this.setCourses(courses);
	}

	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Transcript getTranscript(){
		return this.transcript;
	}
	
	public void setTranscript(Transcript transcript){
		this.transcript = transcript;
	}
	
	public Set<Phone> getStudentPhoneNumbers() {
		return this.studentPhoneNumbers;
	}

	public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
		this.studentPhoneNumbers = studentPhoneNumbers;
	}
	
	public Address getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}

