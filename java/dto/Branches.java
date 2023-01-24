package dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Branches {
    @Id
	private int id;
	private String nameofBranch;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameofBranch() {
		return nameofBranch;
	}
	public void setNameofBranch(String nameofBranch) {
		this.nameofBranch = nameofBranch;
	}
	
}
