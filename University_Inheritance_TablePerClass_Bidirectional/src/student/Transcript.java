package student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Transcripts")
public class Transcript {

	@Column(name = "IdNumber")
	private String idNumber;

	@Id
	@Column(name = "studentID")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "student") )
	private Long studentId;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Student student;

	public Transcript() {}

	public Transcript(String idNumber) {
		this.idNumber = idNumber;
	}

	// public Long getTranscriptId() {
	// return transcriptId;
	// }
	//
	// public void setTranscriptId(Long transcriptId) {
	// this.transcriptId = transcriptId;
	// }

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String toString() {
		String str = "";
		str += idNumber;
		return str;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
