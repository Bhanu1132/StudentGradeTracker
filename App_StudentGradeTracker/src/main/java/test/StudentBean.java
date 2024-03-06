package test;
import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentBean implements Serializable
{
	private String Name;
	private int RollNo, sub1, sub2, sub3, sub4, sub5, sub6, totalMarks;
	private float percentage;
	private String grade;
	private int lMarks, avgMarks, hMarks;
	public StudentBean() {}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public int getSub1() {
		return sub1;
	}
	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}
	public int getSub2() {
		return sub2;
	}
	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}
	public int getSub3() {
		return sub3;
	}
	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}
	public int getSub4() {
		return sub4;
	}
	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}
	public int getSub5() {
		return sub5;
	}
	public void setSub5(int sub5) {
		this.sub5 = sub5;
	}
	public int getSub6() {
		return sub6;
	}
	public void setSub6(int sub6) {
		this.sub6 = sub6;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getlMarks() {
		return lMarks;
	}
	public void setlMarks(int lMarks) {
		this.lMarks = lMarks;
	}
	public int getavgMarks() {
		return avgMarks;
	}
	public void setavgMarks(int avgMarks) {
		this.avgMarks = avgMarks;
	}
	public int gethMarks() {
		return hMarks;
	}
	public void sethMarks(int hMarks) {
		this.hMarks = hMarks;
	}
	
}
