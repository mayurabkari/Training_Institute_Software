package dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Trainer {
    @Id
	private int id;
	private String nameOfTrainer;
	private String subject;
	@ManyToOne
	Branches br;
	public Branches getBr() {
		return br;
	}
	public void setBr(Branches br) {
		this.br = br;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfTrainer() {
		return nameOfTrainer;
	}
	public void setNameOfTrainer(String nameOfTrainer) {
		this.nameOfTrainer = nameOfTrainer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
