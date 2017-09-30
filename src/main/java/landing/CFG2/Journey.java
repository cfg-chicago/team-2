package landing.CFG2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Journeys")
public class Journey   {

	@Column(name = "DATE")
	private Date date;
	@Column(name = "NAME", length = 255)
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long Id;

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

	public Long getId() {
		return Id;
	}

	public void setID(Long iD) {
		Id = iD;
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
