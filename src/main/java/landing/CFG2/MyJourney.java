package landing.CFG2;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MyJourneys")
public class MyJourney   {

	@Column(name = "DATE")
	private Date date;
	@Column(name = "NAME", length = 255)
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long ID;
	@ManyToOne
	@JoinColumn(name = "Users")
	private User user;
	@JoinColumn(name = "journeys")
	@ManyToOne
	private Journey journey;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Journey getJourney() {
		return journey;
	}

	public void setJourney(Journey journey) {
		this.journey = journey;
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
	
}
