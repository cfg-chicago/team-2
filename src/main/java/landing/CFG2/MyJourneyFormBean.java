package landing.CFG2;

import java.io.Serializable;
import java.util.Date;

public class MyJourneyFormBean implements Serializable {
 private Long journey;
 private Date date;
 public Long getJourney() {
	return journey;
}
public void setJourney(Long journey) {
	this.journey = journey;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getReact() {
	return react;
}
public void setReact(String react) {
	this.react = react;
}
public String getReflect() {
	return reflect;
}
public void setReflect(String reflect) {
	this.reflect = reflect;
}
private String react;
 private String reflect;
}
