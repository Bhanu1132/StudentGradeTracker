package test;
import java.io.Serializable;

@SuppressWarnings("serial")
public class CoordinatorBean implements Serializable 
{
	private String Name;
	private int rollNo;
	public CoordinatorBean() {}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
}
