package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Courses {
    @Id
	private int cid;
	private String courseName;
	@ManyToMany
	List<Student> stud;
	@ManyToOne
	Branches bran;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStud() {
		return stud;
	}
	public void setStud(List<Student> stud) {
		this.stud = stud;
	}
	public Branches getBran() {
		return bran;
	}
	public void setBran(Branches bran) {
		this.bran = bran;
	}
	
	
	
}
