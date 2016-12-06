package student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Phones")
class Phone {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long phoneId;
	@Column(name="Type")
	private String phoneType;
	@Column(name="PhoneNumber")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="studentID")
	private Student student;

	public Phone() {}

	public Phone(String phoneType, 
			String phoneNumber,	Student s) {
		this.phoneType = phoneType;
		this.phoneNumber = phoneNumber;
		this.student = s;
	}

	public long getPhoneId() {
		return this.phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
