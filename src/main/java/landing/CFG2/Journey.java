package landing.CFG2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyJourneys")
public class Journey   {

	@Column(name = "DATE")
	private Date date;
	@Column(name = "NAME", length = 255)
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long ID;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
//	public String toString() {
//		return name + " | " + month + " " + day + ", " + year;
//	}
//	
//	public int getYear() {
//		return year;
//	}
//	
//	
//	public int compareTo(Journey other) {
//		if (year > other.getYear()) return 1;
//		else if (year < other.getYear()) return -1;
//		else if ()
//		
//	}
//	
}
