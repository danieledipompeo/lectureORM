package student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transcripts")
public class Transcript {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transcriptId;
	
	@Column(name="IdNumber")
	private String idNumber;
	
	public Transcript(){}
	
	public Transcript(String idNumber){
		this.idNumber = idNumber;
	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String toString(){
		String str = "";
		str += idNumber;
		return str;
	}
}
