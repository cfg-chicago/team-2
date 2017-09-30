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
	
	@Column(name = "happyCount")
	static int happy = 0;
	@Column(name = "ecstaticCount")
	static int ecstatic = 0;
	@Column(name = "mehCount")
	static int meh = 0;
	@Column(name = "sadCount")
	static int sad = 0;

	public static int getHappy() {
		return happy;
	}

	public static void setHappy(int happy) {
		Journey.happy = happy;
	}

	public static int getEcstatic() {
		return ecstatic;
	}

	public static void setEcstatic(int ecstatic) {
		Journey.ecstatic = ecstatic;
	}

	public static int getMeh() {
		return meh;
	}

	public static void setMeh(int meh) {
		Journey.meh = meh;
	}

	public static int getSad() {
		return sad;
	}

	public static void setSad(int sad) {
		Journey.sad = sad;
	}

	public void setId(Long id) {
		Id = id;
	}

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
	
	public void incrementReaction(String emoji) {
		if (emoji.equals("happy")) happy++;
		else if (emoji.equals(ecstatic)) ecstatic++;
		else if (emoji.equals(meh)) meh++;
		else if (emoji.equals(sad)) sad++;
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
