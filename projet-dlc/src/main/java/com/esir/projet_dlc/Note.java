package com.esir.projet_dlc;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "note")
public class Note implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idNote;
	
	@Column(name = "tconst")
    private String tconst;

	@Column(name = "averageRating")
	private String averageRating;
	
	@Column(name = "numVotes")
	private int numVotes;

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(String averageRating) {
		this.averageRating = averageRating;
	}

	public int getNumVotes() {
		return numVotes;
	}

	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	
	
}
