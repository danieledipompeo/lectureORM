package student;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
@Table(name="Persons")
public class Person {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long personId;

	@Column(name = "Name")
	protected String name;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "AddressID")
	protected Address personAddress;
	
	public Person(){}
	
	public long getPersonId() {
		return this.personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String studentName) {
		this.name = studentName;
	}

	public Address getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(Address personAddress) {
		this.personAddress = personAddress;
	}
}
