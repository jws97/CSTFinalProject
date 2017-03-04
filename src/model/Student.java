package model;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Student extends Person {
	private static int id;
	private double gpa;
	private int nElms;
	private int nElmsTook;
	private int nElmsTaking;
	private int nElmsToTake;
	private int[] credits;
	private String major;
	private String[] courseTook;
	private String[] coursesTaking;
	private String[] coursesToTake;

	public Student(String fName, String lName, String phone, Address address, double gpa, int[] numCredits,
			String major, String[] courseTook, String[] coursesTaking, String[] coursesToTake) throws ZipException, PhoneException, GPAException {
		super(fName, lName, phone, address);
		while(true) {
			if(gpa > 4.0 || gpa < 0.0) {
				throw new GPAException("GPA not correct!");
			}else {
				break;
			}
		}
		this.gpa = gpa;
		this.credits = numCredits;
		this.major = major;
		this.courseTook = courseTook;
		this.coursesTaking = coursesTaking;
		this.coursesToTake = coursesToTake;
	}



	public void addCoursesTook(String took) {
		courseTook[nElmsTook++] = took;
	}

	public void addCouresTaking(String taking) {
		coursesTaking[nElmsTaking++] = taking;
	}

	public void addCoursesToTake(String toTake) {
		coursesToTake[nElmsToTake++] = toTake;
	}

	public void add(String taking, int cdts) {
		credits[nElms] = cdts;
		coursesTaking[nElms] = taking;
		nElms++;
	}

	public void displayCoursesTaking() {
		for (int i = 0; i < nElms; i++) {
			System.out.println(coursesTaking[i]);
		}
	}

	public double getCreditsTaking(CourseBag courseBag) {
		double sum = 0;
		for (int i = 0; i < nElmsTaking; i++) {

			sum = sum + courseBag.getCredits(coursesTaking[i]);

		}
		return sum;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) throws GPAException {
		while(true) {
			if(gpa > 4.0 || gpa < 0.0) {
				throw new GPAException("GPA not correct!");
			}else {
				break;
			}
		}
		this.gpa = gpa;
	}

	public int getId(int id) {
		return id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String[] getCourseTook() {
		return courseTook;
	}

	public void setCourseTook(String[] courseTook) {
		this.courseTook = courseTook;
	}

	public String[] getCoursesTaking() {
		return coursesTaking;
	}

	public void setCoursesTaking(String[] coursesTaking) {
		this.coursesTaking = coursesTaking;
	}

	public String[] getCoursesToTake() {
		return coursesToTake;
	}

	public void setCoursesToTake(String[] coursesToTake) {
		this.coursesToTake = coursesToTake;
	}

	public static int getIdAsStatic() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", idNumber=" + idNumber + ", phone=" + phone
				+ ", address=" + address + ", gpa=" + gpa + ", nElms=" + nElms + ", credits=" + Arrays.toString(credits)
				+ ", major=" + major + ", courseTook=" + Arrays.toString(courseTook) + ", coursesTaking="
				+ Arrays.toString(coursesTaking) + ", coursesToTake=" + Arrays.toString(coursesToTake) + "]";
	}

}
